package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentTypeResponse;
import com.rehabilitation.repository.TreatmentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TreatmentTypeServiceImpl implements TreatmentTypeService{
    private final TreatmentTypeRepository treatmentTypeRepository;

    @Autowired
    public TreatmentTypeServiceImpl(TreatmentTypeRepository treatmentTypeRepository) {
        this.treatmentTypeRepository = treatmentTypeRepository;
    }

    @Override
    public List<TreatmentTypeResponse> getAll() {
        return StreamSupport.stream(treatmentTypeRepository.findAll().spliterator(), false)
                .map(treatmentType -> new TreatmentTypeResponse(treatmentType.getTreatment_type_id(), treatmentType.getName()))
                .collect(Collectors.toList());
    }
}
