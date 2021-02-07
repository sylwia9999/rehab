package com.rehabilitation.service;

import com.rehabilitation.Dto.ApplicationResponse;
import com.rehabilitation.Dto.BreakdownResponse;
import com.rehabilitation.Dto.MachineResponse;
import com.rehabilitation.Object.TreatmentType;
import com.rehabilitation.repository.MachineRepository;
import com.rehabilitation.repository.TreatmentRepository;
import com.rehabilitation.repository.TreatmentTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MachineServiceImpl implements MachineService {
    private final MachineRepository machineRepository;
    private final TreatmentTypeRepository treatmentTypeRepository;
    private final TreatmentRepository treatmentRepository;
    private final ApplicationServiceImpl applicationService;
    private final BreakdownServiceImpl breakdownService;
    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }

    @Autowired
    public MachineServiceImpl(MachineRepository machineRepository, TreatmentTypeRepository treatmentTypeRepository, TreatmentRepository treatmentRepository, ApplicationServiceImpl applicationService, BreakdownServiceImpl breakdownService) {
        this.machineRepository = machineRepository;
        this.treatmentTypeRepository = treatmentTypeRepository;
        this.treatmentRepository = treatmentRepository;
        this.applicationService = applicationService;
        this.breakdownService = breakdownService;
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

    @Override
    public List<MachineResponse> getPermittedMachines(int treatmentId, int locationId, Date date) {
        TreatmentType treatmentType = treatmentTypeRepository.getTreatmentTypeById(treatmentRepository.getTreatmentById(treatmentId).getTreatmentType().getTreatment_type_id());
        List<ApplicationResponse> applications = applicationService.getApplicationForTreatment(treatmentType.getTreatment_type_id());
        List<Integer> machinesTypes = new ArrayList<>();
        List<MachineResponse> machines = new ArrayList<>();
        List<Integer> machinesId = new ArrayList<>();

        for (ApplicationResponse application : applications) {
            machinesTypes.add(application.getMachineTypeId());
        }
        for (Integer machinesType : machinesTypes) {
            machines.addAll(this.getMachineType(machinesType));
        }
        for (MachineResponse machine : machines) {
            machinesId.add(machine.getMachine_id());
        }

        List<MachineResponse> machinesPermitted = StreamSupport.stream(machineRepository.findAll().spliterator(), false)
                .map(machine -> new MachineResponse(machine.getMachine_id(), machine.getName(), machine.getLocation().getLocationId(), machine.getMachineType().getMachine_type_id()))
                .filter(machineResponse -> machinesId.contains(machineResponse.getMachine_id()))
                .filter(machineResponse -> machineResponse.getLocation() == locationId)
                .collect(Collectors.toList());

        List<BreakdownResponse> breakdownResponses = new ArrayList<>();
        for (MachineResponse machinePermitted : machinesPermitted) {
            breakdownResponses.addAll(breakdownService.getActiveBreakdownForMachine(machinePermitted.getMachine_id(), date));
        }
        List<Integer> breaks = new ArrayList<>();
        for (BreakdownResponse breakdownResponse : breakdownResponses){
            breaks.add(breakdownResponse.getMachine());
        }
        return machinesPermitted.stream()
                .filter(machineResponse -> !breaks.contains(machineResponse.getMachine_id()))
                .collect(Collectors.toList());
    }
}
