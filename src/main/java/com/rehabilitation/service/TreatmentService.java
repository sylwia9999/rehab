package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentResponse;
import java.util.List;

public interface TreatmentService {
    List<TreatmentResponse> getAll();
    List<TreatmentResponse> getLine(int lineId);
    void updateTreatment(int treatmentId, Long workerId, int machineId, int locationId);
}
