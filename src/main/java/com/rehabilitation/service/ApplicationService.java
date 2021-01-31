package com.rehabilitation.service;

import com.rehabilitation.Dto.ApplicationResponse;

import java.util.List;

public interface ApplicationService {
    List<ApplicationResponse> getAll();
    List<ApplicationResponse> getApplicationForTreatment(int treatmentType);
    List<ApplicationResponse> getApplicationForMachine(int machineType);

}
