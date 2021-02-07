package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentScheduleResponse;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

public interface TreatmentScheduleService {
    List<TreatmentScheduleResponse> getAll();
    List<TreatmentScheduleResponse> getTreatment(int treatmentId);
    List<TreatmentScheduleResponse> getMachine(int machineId, Date date);
    List<TreatmentScheduleResponse> getWorker(Long workerId, Date date);
    List<Time> getHours(int machineId, Date date, Time openTime, Time closeTime, int duration);
    List<Time> getHoursWorker(Long workerId, Date date, int duration);

}
