package com.rehabilitation.controller;

import com.rehabilitation.Dto.RehabilitationPlanResponse;
import com.rehabilitation.service.RehabilitationPlanService;
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
public class RehabilitationPlanController {
    private final RehabilitationPlanService rehabilitationPlanService;

    @Autowired
    public RehabilitationPlanController(RehabilitationPlanService rehabilitationPlanService) {
        this.rehabilitationPlanService = rehabilitationPlanService;
    }

    @GetMapping("/rehab/plans")
    public ResponseEntity<List<RehabilitationPlanResponse>> getAll() {
        return new ResponseEntity<>(rehabilitationPlanService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rehab/plans/patient")
    public ResponseEntity<List<RehabilitationPlanResponse>> getPatient(@RequestParam int patientId) {
        return new ResponseEntity<>(rehabilitationPlanService.getPatient(patientId), HttpStatus.OK);
    }
}
