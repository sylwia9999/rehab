package com.rehabilitation.service;

import com.rehabilitation.Dto.PatientResponse;

import java.util.List;

public interface PatientService {
    List<PatientResponse> getAll();
    List<PatientResponse> getPatientId(int patientId);
}
