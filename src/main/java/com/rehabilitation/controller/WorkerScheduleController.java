package com.rehabilitation.controller;

import com.rehabilitation.Dto.WorkerScheduleResponse;
import com.rehabilitation.service.WorkerScheduleService;
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
public class WorkerScheduleController {
    private final WorkerScheduleService workerScheduleService;

    @Autowired
    public WorkerScheduleController(WorkerScheduleService workerScheduleService) {
        this.workerScheduleService = workerScheduleService;
    }

    @GetMapping("/rehab/workerSchedules")
    public ResponseEntity<List<WorkerScheduleResponse>> getAll() {
        return new ResponseEntity<>(workerScheduleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/rehab/workerSchedules/worker")
    public ResponseEntity<List<WorkerScheduleResponse>> getWorker(@RequestParam Long workerId, @RequestParam Date date) {
        return new ResponseEntity<>(workerScheduleService.getWorker(workerId, date), HttpStatus.OK);
    }

}
