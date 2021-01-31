package com.rehabilitation.service;

import com.rehabilitation.Dto.MachineResponse;
import java.util.List;

public interface MachineService {
    List<MachineResponse> getAll();
    List<MachineResponse> getMachineType(int machineTypeId);
    List<MachineResponse> getMachineLocation(int locationId);
    List<MachineResponse> getMachineTypeAndLocation(int machineTypeId, int locationId);
}
