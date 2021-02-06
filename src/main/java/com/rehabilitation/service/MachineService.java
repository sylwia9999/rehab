package com.rehabilitation.service;

import com.rehabilitation.Dto.MachineResponse;
import com.rehabilitation.Dto.UserResponse;

import java.util.List;

public interface MachineService {
    List<MachineResponse> getAll();
    List<MachineResponse> getMachineType(int machineTypeId);
    List<MachineResponse> getMachineLocation(int locationId);
    List<MachineResponse> getMachineTypeAndLocation(int machineTypeId, int locationId);
    List<MachineResponse> getPermittedMachines(int treatmentId, int locationId);

}
