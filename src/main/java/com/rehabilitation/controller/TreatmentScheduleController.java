package com.rehabilitation.controller;

import com.rehabilitation.Dto.TreatmentScheduleResponse;
import com.rehabilitation.service.TreatmentScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Date;
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

    @GetMapping("/rehab/schedule/machine")
    public ResponseEntity<List<TreatmentScheduleResponse>> getMachine(@RequestParam int machineId, @RequestParam Date date) {
        return new ResponseEntity<>(treatmentScheduleService.getMachine(machineId, date), HttpStatus.OK);
    }

    @GetMapping("/rehab/schedule/hours/machine")
    public List<Time> getHours(@RequestParam int machineId, @RequestParam Date date, @RequestParam Time openTime, @RequestParam Time closeTime, @RequestParam int duration) {
        return treatmentScheduleService.getHours(machineId, date, openTime, closeTime, duration);
    }

    @GetMapping("/rehab/schedule/hours/worker")
    public List<Time> getHoursWorker(@RequestParam Long workerId, @RequestParam Date date,@RequestParam int duration) {
        return treatmentScheduleService.getHoursWorker(workerId, date, duration);
    }

}
