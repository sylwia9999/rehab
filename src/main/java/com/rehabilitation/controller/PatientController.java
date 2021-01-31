package com.rehabilitation.controller;

import com.rehabilitation.Dto.PatientResponse;
import com.rehabilitation.service.PatientService;
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
public class PatientController {
    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/rehab/patients")
    public ResponseEntity<List<PatientResponse>> getAll() {
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rehab/patient")
    public ResponseEntity<List<PatientResponse>> getPatient(@RequestParam int patientId) {
        return new ResponseEntity<>(patientService.getPatientId(patientId), HttpStatus.OK);
    }
}
