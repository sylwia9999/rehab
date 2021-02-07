package com.rehabilitation.service;

import com.rehabilitation.Dto.WorkerScheduleResponse;
import com.rehabilitation.repository.WorkerScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WorkerScheduleServiceImpl implements WorkerScheduleService{
    private final WorkerScheduleRepository workerScheduleRepository;
    @Autowired
    public WorkerScheduleServiceImpl(WorkerScheduleRepository workerScheduleRepository) {
        this.workerScheduleRepository = workerScheduleRepository;
    }

    @Override
    public List<WorkerScheduleResponse> getAll() {
        return StreamSupport.stream(workerScheduleRepository.findAll().spliterator(), false)
                .map(workerSchedule -> new WorkerScheduleResponse(workerSchedule.getWorker_schedule_id(), workerSchedule.getDate(), workerSchedule.getTime_from(), workerSchedule.getTime_to(), workerSchedule.getUser().getUserId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<WorkerScheduleResponse> getWorker(Long workerId, Date date) {
        return StreamSupport.stream(workerScheduleRepository.findAll().spliterator(), false)
                .map(workerSchedule -> new WorkerScheduleResponse(workerSchedule.getWorker_schedule_id(), workerSchedule.getDate(), workerSchedule.getTime_from(), workerSchedule.getTime_to(), workerSchedule.getUser().getUserId()))
                .filter(workerScheduleResponse -> workerScheduleResponse.getUser().equals(workerId))
                .filter(workerScheduleResponse -> workerScheduleResponse.getDate().equals(date))
                .collect(Collectors.toList());
    }

}
