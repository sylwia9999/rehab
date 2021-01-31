package com.rehabilitation.controller;

import com.rehabilitation.Dto.BreakdownResponse;
import com.rehabilitation.service.BreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class BreakdownController {
    private final BreakdownService breakdownService;

    @Autowired
    public BreakdownController(BreakdownService breakdownService) {
        this.breakdownService = breakdownService;
    }

    @GetMapping("/rehab/breakdowns")
    public ResponseEntity<List<BreakdownResponse>> getAll() {
        return new ResponseEntity<>(breakdownService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/rehab/breakdowns/machine")
    public ResponseEntity<List<BreakdownResponse>> getActiveMachine(@RequestParam int machineId, @RequestParam Date date) {
        return new ResponseEntity<>(breakdownService.getActiveBreakdownForMachine(machineId, date), HttpStatus.OK);
    }
    @GetMapping("/rehab/breakdowns/active")
    public ResponseEntity<List<BreakdownResponse>> getActive(@RequestParam Date date) {
        return new ResponseEntity<>(breakdownService.getActiveBreakdowns(date), HttpStatus.OK);
    }
}
