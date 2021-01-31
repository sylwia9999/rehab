package com.rehabilitation.controller;

import com.rehabilitation.Dto.RehabilitationPlanLineResponse;
import com.rehabilitation.service.RehabilitationPlanLineService;
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
public class RehabilitationPlanLineController {
    private final RehabilitationPlanLineService rehabilitationPlanLineService;

    @Autowired
    public RehabilitationPlanLineController(RehabilitationPlanLineService rehabilitationPlanLineService) {
        this.rehabilitationPlanLineService = rehabilitationPlanLineService;
    }

    @GetMapping("/rehab/planLines")
    public ResponseEntity<List<RehabilitationPlanLineResponse>> getAll() {
        return new ResponseEntity<>(rehabilitationPlanLineService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/rehab/planLines/plan")
    public ResponseEntity<List<RehabilitationPlanLineResponse>> getPlan(@RequestParam int planId) {
        return new ResponseEntity<>(rehabilitationPlanLineService.getPlanId(planId), HttpStatus.OK);
    }
}
