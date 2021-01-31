package com.rehabilitation.controller;

import com.rehabilitation.Dto.RoleRequest;
import com.rehabilitation.Dto.RoleResponse;
import com.rehabilitation.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class RoleController {
    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/rehab/role")
    public ResponseEntity<List<RoleResponse>> getAll() {
        return new ResponseEntity<>(roleService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/rehab/role")
    public ResponseEntity addRole(@RequestBody RoleRequest roleRequest) {
        roleService.addRole(roleRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("/rehab/role/delete")
    public ResponseEntity deleteRole(@RequestParam Integer roleId) {
        roleService.deleteRole(roleId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
