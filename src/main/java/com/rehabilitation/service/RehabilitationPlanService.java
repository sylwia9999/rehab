package com.rehabilitation.service;

import com.rehabilitation.Dto.RehabilitationPlanResponse;

import java.util.List;

public interface RehabilitationPlanService {
    List<RehabilitationPlanResponse> getAll();
    List<RehabilitationPlanResponse> getPatient(int patientId);
}
