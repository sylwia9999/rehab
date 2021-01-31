package com.rehabilitation.service;

import com.rehabilitation.Dto.ApplicationResponse;
import com.rehabilitation.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private final ApplicationRepository applicationRepository;

    @Autowired ApplicationServiceImpl(ApplicationRepository applicationRepository) {this.applicationRepository = applicationRepository;}

    @Override
    public List<ApplicationResponse> getAll() {
        return StreamSupport.stream(applicationRepository.findAll().spliterator(), false)
                .map(application -> new ApplicationResponse(application.getApplication_id(), application.getTreatmentType().getTreatment_type_id(), application.getMachineType().getMachine_type_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationResponse> getApplicationForTreatment(int treatmentType) {
        return StreamSupport.stream(applicationRepository.findAll().spliterator(), false)
                .map(application -> new ApplicationResponse(application.getApplication_id(), application.getTreatmentType().getTreatment_type_id(), application.getMachineType().getMachine_type_id()))
                .filter(applicationResponse -> applicationResponse.getTreatmentTypeId() == treatmentType)
                .collect(Collectors.toList());
    }

    @Override
    public List<ApplicationResponse> getApplicationForMachine(int machineType) {
        return StreamSupport.stream(applicationRepository.findAll().spliterator(), false)
                .map(application -> new ApplicationResponse(application.getApplication_id(), application.getTreatmentType().getTreatment_type_id(), application.getMachineType().getMachine_type_id()))
                .filter(applicationResponse -> applicationResponse.getMachineTypeId() == machineType)
                .collect(Collectors.toList());
    }
}
