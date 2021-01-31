package com.rehabilitation.service;

import com.rehabilitation.Dto.LocationResponse;
import com.rehabilitation.Dto.MachineResponse;
import com.rehabilitation.repository.MachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public List<MachineResponse> getAll() {
        return StreamSupport.stream(machineRepository.findAll().spliterator(), false)
                .map(machine -> new MachineResponse(machine.getMachine_id(), machine.getName(), machine.getLocation().getLocationId(), machine.getMachineType().getMachine_type_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MachineResponse> getMachineType(int machineTypeId) {
        return StreamSupport.stream(machineRepository.findAll().spliterator(), false)
                .map(machine -> new MachineResponse(machine.getMachine_id(), machine.getName(), machine.getLocation().getLocationId(), machine.getMachineType().getMachine_type_id()))
                .filter(machineResponse -> machineResponse.getMachineType() == machineTypeId)
                .collect(Collectors.toList());
    }

    @Override
    public List<MachineResponse> getMachineLocation(int locationId) {
        return StreamSupport.stream(machineRepository.findAll().spliterator(), false)
                .map(machine -> new MachineResponse(machine.getMachine_id(), machine.getName(), machine.getLocation().getLocationId(), machine.getMachineType().getMachine_type_id()))
                .filter(machineResponse -> machineResponse.getLocation() == locationId)
                .collect(Collectors.toList());
    }

    @Override
    public List<MachineResponse> getMachineTypeAndLocation(int machineTypeId, int locationId) {
        return StreamSupport.stream(machineRepository.findAll().spliterator(), false)
                .map(machine -> new MachineResponse(machine.getMachine_id(), machine.getName(), machine.getLocation().getLocationId(), machine.getMachineType().getMachine_type_id()))
                .filter(machineResponse -> machineResponse.getMachineType() == machineTypeId)
                .filter(machineResponse -> machineResponse.getLocation() == locationId)
                .collect(Collectors.toList());
    }
}
