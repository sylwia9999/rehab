package com.rehabilitation.service;

import com.rehabilitation.Dto.PatientResponse;
import com.rehabilitation.Dto.RoleResponse;
import com.rehabilitation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public List<PatientResponse> getAll() {
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .map(patient -> new PatientResponse(patient.getPatient_id(), patient.getFirstName(), patient.getLastName(), patient.getEmail(), patient.getAddress(), patient.getPhoneNumber(), patient.getPesel(), patient.getTime_preferences_from(), patient.getTime_preferences_to(), patient.getLocation_preferences().getLocationId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<PatientResponse> getPatientId(int patientId) {
        return StreamSupport.stream(patientRepository.findAll().spliterator(), false)
                .map(patient -> new PatientResponse(patient.getPatient_id(), patient.getFirstName(), patient.getLastName(), patient.getEmail(), patient.getAddress(), patient.getPhoneNumber(), patient.getPesel(), patient.getTime_preferences_from(), patient.getTime_preferences_to(), patient.getLocation_preferences().getLocationId()))
                .filter(patientResponse -> patientResponse.getPatient_id() == patientId)
                .collect(Collectors.toList());
    }
}
