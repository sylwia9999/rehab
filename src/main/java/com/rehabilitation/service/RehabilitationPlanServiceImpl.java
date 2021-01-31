package com.rehabilitation.service;

import com.rehabilitation.Dto.RehabilitationPlanResponse;
import com.rehabilitation.repository.RehabilitationPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RehabilitationPlanServiceImpl implements RehabilitationPlanService{
    private final RehabilitationPlanRepository rehabilitationPlanRepository;

    @Autowired
    public RehabilitationPlanServiceImpl(RehabilitationPlanRepository rehabilitationPlanRepository) {
        this.rehabilitationPlanRepository = rehabilitationPlanRepository;
    }

    @Override
    public List<RehabilitationPlanResponse> getAll() {
        return StreamSupport.stream(rehabilitationPlanRepository.findAll().spliterator(), false)
                .map(rehabilitationPlan -> new RehabilitationPlanResponse(rehabilitationPlan.getPlan_id(), rehabilitationPlan.getCreation_date(), rehabilitationPlan.getPatient().getPatient_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RehabilitationPlanResponse> getPatient(int patientId) {
        return StreamSupport.stream(rehabilitationPlanRepository.findAll().spliterator(), false)
                .map(rehabilitationPlan -> new RehabilitationPlanResponse(rehabilitationPlan.getPlan_id(), rehabilitationPlan.getCreation_date(), rehabilitationPlan.getPatient().getPatient_id()))
                .filter(rehabilitationPlanResponse -> rehabilitationPlanResponse.getPatient() == patientId)
                .collect(Collectors.toList());
    }
}
