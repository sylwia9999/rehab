package com.rehabilitation.service;

import com.rehabilitation.Dto.RoleRequest;
import com.rehabilitation.Dto.RoleResponse;
import java.util.List;

public interface RoleService {
    List<RoleResponse> getAll();
    List<RoleResponse> getRole(String name);
    void addRole(RoleRequest roleRequest);
    void deleteRole(Integer roleId);
}