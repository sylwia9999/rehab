package com.rehabilitation.controller;

import com.rehabilitation.Dto.TreatmentResponse;
import com.rehabilitation.service.TreatmentService;
import com.rehabilitation.service.TreatmentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TreatmentController {
    private final TreatmentService treatmentService;
    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }

    @Autowired
    public TreatmentController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping("/rehab/treatments")
    public ResponseEntity<List<TreatmentResponse>> getAll() {
        return new ResponseEntity<>(treatmentService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/rehab/treatments/patient")
    public ResponseEntity<List<TreatmentResponse>> getPatient(@RequestParam int patientId) {
        return new ResponseEntity<>(treatmentService.getPlan(patientId), HttpStatus.OK);
    }

}
