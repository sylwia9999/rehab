package com.rehabilitation.controller;

import com.rehabilitation.Dto.MachineResponse;
import com.rehabilitation.service.MachineService;
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
public class MachineController {
    private final MachineService machineService;

    @Autowired
    public MachineController(MachineService machineService) {
        this.machineService = machineService;
    }

    @GetMapping("/rehab/machines")
    public ResponseEntity<List<MachineResponse>> getAll() {
        return new ResponseEntity<>(machineService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rehab/machines/type")
    public ResponseEntity<List<MachineResponse>> getType(@RequestParam int machineTypeId) {
        return new ResponseEntity<>(machineService.getMachineType(machineTypeId), HttpStatus.OK);
    }

    @GetMapping("/rehab/machines/location")
    public ResponseEntity<List<MachineResponse>> getLocation(@RequestParam int locationId) {
        return new ResponseEntity<>(machineService.getMachineLocation(locationId), HttpStatus.OK);
    }

    @GetMapping("/rehab/machines/type/location")
    public ResponseEntity<List<MachineResponse>> getTypeLocation(@RequestParam int machineTypeId, @RequestParam int locationId) {
        return new ResponseEntity<>(machineService.getMachineTypeAndLocation(machineTypeId, locationId), HttpStatus.OK);
    }
}
