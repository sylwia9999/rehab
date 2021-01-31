package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentResponse;
import com.rehabilitation.Object.Treatment;
import com.rehabilitation.repository.LocationRepository;
import com.rehabilitation.repository.MachineRepository;
import com.rehabilitation.repository.TreatmentRepository;
import com.rehabilitation.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TreatmentServiceImpl implements TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final LocationRepository locationRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private static final Logger LOGGER;

    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }

    @Autowired
    public TreatmentServiceImpl(TreatmentRepository treatmentRepository, LocationRepository locationRepository, MachineRepository machineRepository, UserRepository userRepository) {
        this.treatmentRepository = treatmentRepository;
        this.locationRepository = locationRepository;
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TreatmentResponse> getAll() {
        return StreamSupport.stream(treatmentRepository.findAll().spliterator(), false)
                .map(treatment -> new TreatmentResponse(treatment.getTreatment_id(), treatment.getName(), treatment.getDuration(), treatment.getOrder(), treatment.getTreatmentType().getTreatment_type_id(), treatment.getRehabilitationPlanLine().getLine_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TreatmentResponse> getLine(int lineId) {
        return StreamSupport.stream(treatmentRepository.findAll().spliterator(), false)
                .map(treatment -> new TreatmentResponse(treatment.getTreatment_id(), treatment.getName(), treatment.getDuration(), treatment.getOrder(), treatment.getTreatmentType().getTreatment_type_id(), treatment.getRehabilitationPlanLine().getLine_id()))
                .filter(treatmentResponse -> treatmentResponse.getRehabilitationPlanLine() == lineId)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTreatment(int treatmentId, Long workerId, int machineId, int locationId) {
        Treatment treatment = treatmentRepository.findById(treatmentId).get();
        LOGGER.info(treatment.toString());
        treatment.setLocation(locationRepository.findById(locationId).orElseThrow(Error::new));
        treatment.setMachine(machineRepository.findById(machineId).orElseThrow(Error::new));
        treatment.setUser(userRepository.findById(workerId).orElseThrow(Error::new));
        treatmentRepository.save(treatment);
    }
}
