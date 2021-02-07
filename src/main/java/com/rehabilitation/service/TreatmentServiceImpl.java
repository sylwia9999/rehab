package com.rehabilitation.service;

import com.rehabilitation.Dto.RehabilitationPlanResponse;
import com.rehabilitation.Dto.TreatmentResponse;
import com.rehabilitation.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TreatmentServiceImpl implements TreatmentService {
    private final TreatmentRepository treatmentRepository;
    private final LocationRepository locationRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final RehabilitationPlanServiceImpl rehabilitationPlanService;
    private static final Logger LOGGER;
    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }

    @Autowired
    public TreatmentServiceImpl(TreatmentRepository treatmentRepository, LocationRepository locationRepository, MachineRepository machineRepository, UserRepository userRepository, RehabilitationPlanServiceImpl rehabilitationPlanService) {
        this.treatmentRepository = treatmentRepository;
        this.locationRepository = locationRepository;
        this.machineRepository = machineRepository;
        this.userRepository = userRepository;
        this.rehabilitationPlanService = rehabilitationPlanService;
    }

    @Override
    public List<TreatmentResponse> getAll() {
        return StreamSupport.stream(treatmentRepository.findAll().spliterator(), false)
                .map(treatment -> new TreatmentResponse(treatment.getTreatment_id(), treatment.getName(), treatment.getDuration(), treatment.getOrder(), treatment.getTreatmentType().getTreatment_type_id(), treatment.getRehabilitationPlanLine().getPlan_id(), treatment.getRepeat_number()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TreatmentResponse> getPlan(int patientId, int whichDay) {
        List<RehabilitationPlanResponse> plans = rehabilitationPlanService.getPatient(patientId);
        RehabilitationPlanResponse thisPlan = plans.get(0);
        Date lastDate = plans.get(0).getCreation_date();
        for (RehabilitationPlanResponse plan: plans){
            if (plan.getCreation_date().after(lastDate)){
                thisPlan = plan;
                lastDate = plan.getCreation_date();
            }
        }
        RehabilitationPlanResponse finalThisPlan = thisPlan;
        return  StreamSupport.stream(treatmentRepository.findAll().spliterator(), false)
                .map(treatment -> new TreatmentResponse(treatment.getTreatment_id(), treatment.getName(), treatment.getDuration(), treatment.getOrder(), treatment.getTreatmentType().getTreatment_type_id(), treatment.getRehabilitationPlanLine().getPlan_id(), treatment.getRepeat_number()))
                .filter(treatmentResponse -> treatmentResponse.getRehabilitationPlan() == finalThisPlan.getPlan_id())
                .filter(treatmentResponse -> treatmentResponse.getRepeat_number() >= whichDay+1)
                .collect(Collectors.toList());
    }

}
