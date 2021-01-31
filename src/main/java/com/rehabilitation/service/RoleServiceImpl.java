package com.rehabilitation.service;
import com.rehabilitation.Dto.RoleRequest;
import com.rehabilitation.Dto.RoleResponse;
import com.rehabilitation.Object.Role;
import com.rehabilitation.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleResponse> getAll() {
        return StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                .map(role -> new RoleResponse(role.getRole_id(), role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RoleResponse> getRole(String name) {
        return StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                .map(role -> new RoleResponse(role.getRole_id(), role.getName()))
                .filter(roleResponse -> roleResponse.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Override
    public void addRole(RoleRequest roleRequest) {
        Role roleEntity = new Role();
        roleEntity.setName(roleRequest.getName());

        roleRepository.save(roleEntity);
    }

    @Override
    public void deleteRole(Integer roleId){
        roleRepository.deleteById(roleId);
    }
}

