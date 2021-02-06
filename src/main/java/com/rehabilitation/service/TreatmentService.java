package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentResponse;
import java.util.List;

public interface TreatmentService {
    List<TreatmentResponse> getAll();
    List<TreatmentResponse> getPlan(int patientId);
}
