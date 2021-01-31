package com.rehabilitation.service;

import com.rehabilitation.Dto.PermissionResponse;

import java.util.List;

public interface PermissionService {
    List<PermissionResponse> getAll();
    List<PermissionResponse> getAllForWorker(int workerId);
    List<PermissionResponse> getAllForTreatment(int treatmentTypeId);

}
