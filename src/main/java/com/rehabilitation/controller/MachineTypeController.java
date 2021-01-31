package com.rehabilitation.controller;

import com.rehabilitation.Dto.MachineTypeResponse;
import com.rehabilitation.service.MachineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class MachineTypeController {
    private final MachineTypeService machineTypeService;

    @Autowired
    public MachineTypeController(MachineTypeService machineTypeService) {
        this.machineTypeService = machineTypeService;
    }

    @GetMapping("/rehab/machineTypes")
    public ResponseEntity<List<MachineTypeResponse>> getAll() {
        return new ResponseEntity<>(machineTypeService.getAll(), HttpStatus.OK);
    }
}
