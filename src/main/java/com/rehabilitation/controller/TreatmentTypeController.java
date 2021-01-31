package com.rehabilitation.controller;

import com.rehabilitation.Dto.TreatmentTypeResponse;
import com.rehabilitation.service.TreatmentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TreatmentTypeController {
    private final TreatmentTypeService treatmentTypeService;

    @Autowired
    public TreatmentTypeController(TreatmentTypeService treatmentTypeService) {
        this.treatmentTypeService = treatmentTypeService;
    }

    @GetMapping("/rehab/treatmentTypes")
    public ResponseEntity<List<TreatmentTypeResponse>> getAll() {
        return new ResponseEntity<>(treatmentTypeService.getAll(), HttpStatus.OK);
    }
}
