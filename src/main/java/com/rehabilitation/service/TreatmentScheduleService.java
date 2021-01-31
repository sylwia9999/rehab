package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentScheduleResponse;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface TreatmentScheduleService {
    List<TreatmentScheduleResponse> getAll();
    List<TreatmentScheduleResponse> getTreatment(int treatmentId);
    void updateTreatmentSchedule(int treatmentId, Date date, Time timeFrom, Time timeTo);
}
