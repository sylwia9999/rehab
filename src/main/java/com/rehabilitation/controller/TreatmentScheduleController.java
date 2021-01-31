package com.rehabilitation.controller;

import com.rehabilitation.Dto.TreatmentScheduleResponse;
import com.rehabilitation.service.TreatmentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class TreatmentScheduleController {
    private final TreatmentScheduleService treatmentScheduleService;

    @Autowired
    public TreatmentScheduleController(TreatmentScheduleService treatmentScheduleService) {
        this.treatmentScheduleService = treatmentScheduleService;
    }

    @GetMapping("/rehab/treatmentSchedules")
    public ResponseEntity<List<TreatmentScheduleResponse>> getAll() {
        return new ResponseEntity<>(treatmentScheduleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rehab/schedule/treatment")
    public ResponseEntity<List<TreatmentScheduleResponse>> getTreatment(@RequestParam int treatmentId) {
        return new ResponseEntity<>(treatmentScheduleService.getTreatment(treatmentId), HttpStatus.OK);
    }

    @PutMapping("/rehab/schedule/update")
    public ResponseEntity updateSchedule(@RequestParam int treatmentId, @RequestParam Date date, @RequestParam Time timeFrom, @RequestParam Time timeTo){
        treatmentScheduleService.updateTreatmentSchedule(treatmentId, date, timeFrom, timeTo);
        return new ResponseEntity(HttpStatus.OK);
    }
}
