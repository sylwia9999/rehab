package com.rehabilitation.service;

import com.rehabilitation.Dto.WorkerScheduleResponse;

import java.sql.Date;
import java.util.List;

public interface WorkerScheduleService {
    List<WorkerScheduleResponse> getAll();
    List<WorkerScheduleResponse> getWorker(Long workerId, Date date);
}
