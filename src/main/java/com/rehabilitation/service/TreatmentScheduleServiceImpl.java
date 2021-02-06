package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentScheduleResponse;
import com.rehabilitation.Object.TreatmentSchedule;
import com.rehabilitation.repository.TreatmentRepository;
import com.rehabilitation.repository.TreatmentScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TreatmentScheduleServiceImpl implements TreatmentScheduleService {
    private final TreatmentScheduleRepository treatmentScheduleRepository;
    private final TreatmentRepository treatmentRepository;
    private static final Logger LOGGER;
    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }

    @Autowired
    public TreatmentScheduleServiceImpl(TreatmentScheduleRepository treatmentScheduleRepository, TreatmentRepository treatmentRepository) {
        this.treatmentScheduleRepository = treatmentScheduleRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public List<TreatmentScheduleResponse> getAll() {
        return StreamSupport.stream(treatmentScheduleRepository.findAll().spliterator(), false)
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getWorker().getUserId(), treatmentSchedule.getLocation().getLocationId(), treatmentSchedule.getMachine().getMachine_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TreatmentScheduleResponse> getTreatment(int treatmentId) {
        return StreamSupport.stream(treatmentScheduleRepository.findAll().spliterator(), false)
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getWorker().getUserId(), treatmentSchedule.getLocation().getLocationId(), treatmentSchedule.getMachine().getMachine_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getTreatment() == treatmentId)
                .collect(Collectors.toList());
    }

}
