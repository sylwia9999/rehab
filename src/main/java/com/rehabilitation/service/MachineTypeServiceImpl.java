package com.rehabilitation.service;

import com.rehabilitation.Dto.MachineTypeResponse;
import com.rehabilitation.repository.MachineTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MachineTypeServiceImpl implements MachineTypeService{
    private final MachineTypeRepository machineTypeRepository;

    @Autowired
    public MachineTypeServiceImpl(MachineTypeRepository machineTypeRepository) {
        this.machineTypeRepository = machineTypeRepository;
    }

    @Override
    public List<MachineTypeResponse> getAll() {
        return StreamSupport.stream(machineTypeRepository.findAll().spliterator(), false)
                .map(machineType -> new MachineTypeResponse(machineType.getMachine_type_id(), machineType.getName()))
                .collect(Collectors.toList());
    }
}
