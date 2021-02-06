package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentScheduleResponse;

import java.sql.Time;
import java.sql.Date;
import java.util.List;

public interface TreatmentScheduleService {
    List<TreatmentScheduleResponse> getAll();
    List<TreatmentScheduleResponse> getTreatment(int treatmentId);
}
