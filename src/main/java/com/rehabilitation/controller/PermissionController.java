package com.rehabilitation.controller;

import com.rehabilitation.Dto.PermissionResponse;
import com.rehabilitation.Dto.RoleResponse;
import com.rehabilitation.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/rehab/permissions")
    public ResponseEntity<List<PermissionResponse>> getAll() {
        return new ResponseEntity<>(permissionService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/rehab/permissions/worker")
    public ResponseEntity<List<PermissionResponse>> getWorker(@RequestParam int workerId) {
        return new ResponseEntity<>(permissionService.getAllForWorker(workerId), HttpStatus.OK);
    }
    @GetMapping("/rehab/permissions/treatment")
    public ResponseEntity<List<PermissionResponse>> getTreatment(@RequestParam int treatmentId) {
        return new ResponseEntity<>(permissionService.getAllForTreatment(treatmentId), HttpStatus.OK);
    }
}
