package com.rehabilitation.controller;

import com.rehabilitation.Dto.ApplicationResponse;
import com.rehabilitation.service.ApplicationService;
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
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/rehab/applications")
    public ResponseEntity<List<ApplicationResponse>> getAll() {
        return new ResponseEntity<>(applicationService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rehab/applications/treatment")
    public ResponseEntity<List<ApplicationResponse>> getApplicationsForTreatment(@RequestParam int treatmentId) {
        return new ResponseEntity<>(applicationService.getApplicationForTreatment(treatmentId), HttpStatus.OK);
    }

    @GetMapping("/rehab/applications/machine")
    public ResponseEntity<List<ApplicationResponse>> getApplicationForMachine(@RequestParam int machineId) {
        return new ResponseEntity<>(applicationService.getApplicationForMachine(machineId), HttpStatus.OK);
    }
}
