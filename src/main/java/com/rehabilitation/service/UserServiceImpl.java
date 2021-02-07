package com.rehabilitation.service;

import com.rehabilitation.Dto.PermissionResponse;
import com.rehabilitation.Dto.UserRequest;
import com.rehabilitation.Dto.UserResponse;
import com.rehabilitation.Dto.WorkerScheduleResponse;
import com.rehabilitation.Object.TreatmentType;
import com.rehabilitation.Object.User;
import com.rehabilitation.UsersDetails;
import com.rehabilitation.repository.RoleRepository;
import com.rehabilitation.repository.TreatmentRepository;
import com.rehabilitation.repository.TreatmentTypeRepository;
import com.rehabilitation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.lang.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class UserServiceImpl implements UserService, UserDetailsService, Serializable {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionServiceImpl permissionService;
    private final WorkerScheduleServiceImpl workerScheduleService;
    private final TreatmentTypeRepository treatmentTypeRepository;
    private final TreatmentRepository treatmentRepository;
    private static final Logger LOGGER;
    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }


    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PermissionServiceImpl permissionService, WorkerScheduleServiceImpl workerScheduleService, TreatmentTypeRepository treatmentTypeRepository, TreatmentRepository treatmentRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
        this.workerScheduleService = workerScheduleService;
        this.treatmentTypeRepository = treatmentTypeRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public List<UserResponse> getByEmailPassword(@RequestBody String email, @RequestBody String password) {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> new UserResponse(user.getUserId(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getPassword(), user.getSubscription(), user.getRole().getRole_id(), user.getLocation().getLocationId()))
                .filter(userResponse -> userResponse.getEmail().equals(email))
                .filter(userResponse -> passwordEncoder().matches(password, userResponse.getPassword()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserResponse> getByEmail(@RequestBody String email){
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> new UserResponse(user.getUserId(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getPassword(), user.getSubscription(), user.getRole().getRole_id(), user.getLocation().getLocationId()))
                .filter(userResponse -> userResponse.getEmail().equals(email))
                .collect(Collectors.toList());

    }
    @Override
    public void registerUser(@RequestBody UserRequest userRequest) {
        User user = new User();
        user.setName(userRequest.getName());
        user.setPhoneNumber(userRequest.getPhoneNumber());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder().encode(userRequest.getPassword()));
        user.setSubscription(false);
        user.setRole(roleRepository.findById(1).orElseThrow(Error::new));

        userRepository.save(user);
    }

    @Override
    public List<UserResponse> getPermittedWorkers(int treatmentId, int locationId, Date date) {
        TreatmentType treatmentType = treatmentTypeRepository.getTreatmentTypeById(treatmentRepository.getTreatmentById(treatmentId).getTreatmentType().getTreatment_type_id());
        List<PermissionResponse> permissions = permissionService.getAllForTreatment(treatmentType.getTreatment_type_id());
        List<Long> users = new ArrayList<>();
        for (PermissionResponse permission : permissions) {
            users.add(permission.getWorker());
        }
        List<UserResponse> permittedUsers = StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(user -> new UserResponse(user.getUserId(), user.getName(), user.getPhoneNumber(), user.getEmail(), user.getPassword(), user.getSubscription(), user.getRole().getRole_id(), user.getLocation().getLocationId()))
                .filter(userResponse -> users.contains(userResponse.getId()))
                .filter(userResponse -> userResponse.getLocation_id() == locationId)
                .collect(Collectors.toList());

        List<WorkerScheduleResponse> workerScheduleResponses = new ArrayList<>();
        for (UserResponse permittedUser : permittedUsers) {
            workerScheduleResponses.addAll(workerScheduleService.getWorker(permittedUser.getId(), date));
        }

        List<Long> schedules = new ArrayList<>();
        for (WorkerScheduleResponse workerScheduleResponse : workerScheduleResponses) {
            schedules.add(workerScheduleResponse.getUser());
        }
        return permittedUsers.stream()
                .filter(userResponse -> schedules.contains(userResponse.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException("Could not find user with this email");
        }
        return new UsersDetails(user);
    }
}
