package com.rehabilitation.service;

import com.rehabilitation.Dto.RehabilitationPlanLineResponse;
import com.rehabilitation.repository.RehabilitationPlanLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RehabilitationPlanLineServiceImpl implements RehabilitationPlanLineService{
    private final RehabilitationPlanLineRepository rehabilitationPlanLineRepository;

    @Autowired
    public RehabilitationPlanLineServiceImpl(RehabilitationPlanLineRepository rehabilitationPlanLineRepository) {
        this.rehabilitationPlanLineRepository = rehabilitationPlanLineRepository;
    }

    @Override
    public List<RehabilitationPlanLineResponse> getAll() {
        return StreamSupport.stream(rehabilitationPlanLineRepository.findAll().spliterator(), false)
                .map(rehabilitationPlanLine -> new RehabilitationPlanLineResponse(rehabilitationPlanLine.getLine_id(), rehabilitationPlanLine.getRepeat_number(), rehabilitationPlanLine.getRehabilitationPlan().getPlan_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RehabilitationPlanLineResponse> getPlanId(int planId) {
        return StreamSupport.stream(rehabilitationPlanLineRepository.findAll().spliterator(), false)
                .map(rehabilitationPlanLine -> new RehabilitationPlanLineResponse(rehabilitationPlanLine.getLine_id(), rehabilitationPlanLine.getRepeat_number(), rehabilitationPlanLine.getRehabilitationPlan().getPlan_id()))
                .filter(rehabilitationPlanLineResponse -> rehabilitationPlanLineResponse.getRehabilitationPlan() == planId)
                .collect(Collectors.toList());
    }
}
