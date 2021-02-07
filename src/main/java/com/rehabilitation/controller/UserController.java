package com.rehabilitation.controller;

import com.rehabilitation.Dto.AuthenticationResponse;
import com.rehabilitation.Dto.UserRequest;
import com.rehabilitation.Dto.UserResponse;
import com.rehabilitation.service.JwtUtil;
import com.rehabilitation.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users/Email")
    public ResponseEntity<List<UserResponse>> getByEmail(UserRequest userRequest) {
        return new ResponseEntity<>(userService.getByEmail(userRequest.getEmail()), HttpStatus.OK);
    }

    @GetMapping(value = "/users/Email/Password")
    public ResponseEntity<List<UserResponse>> getByEmailPassword(UserRequest userRequest) {
        return new ResponseEntity<>(userService.getByEmailPassword(userRequest.getEmail(), userRequest.getPassword()), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity registerUser(@RequestBody UserRequest userRequest) throws Exception{
        String tmpEmail = userRequest.getEmail();
        if(tmpEmail != null && !tmpEmail.equals("")){
            if(!userService.getByEmail(tmpEmail).isEmpty()){
                throw new Exception("There is already account with that email. Try to login.");
            }
        }
        userService.registerUser(userRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) throws Exception{
        try{
            manager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails usersDetails = userService.loadUserByUsername(email);
        final String jwt = jwtTokenUtil.generateToken(usersDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping(value = "/users/treatment")
    public ResponseEntity<List<UserResponse>> getPermittedWorkers(@RequestParam int treatmentId, @RequestParam int locationId,@RequestParam Date date) {
        return new ResponseEntity<>(userService.getPermittedWorkers(treatmentId, locationId, date), HttpStatus.OK);
    }
}
