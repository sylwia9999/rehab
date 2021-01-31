package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentScheduleResponse;
import com.rehabilitation.Object.TreatmentSchedule;
import com.rehabilitation.repository.TreatmentScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TreatmentScheduleServiceImpl implements TreatmentScheduleService {
    private final TreatmentScheduleRepository treatmentScheduleRepository;

    @Autowired
    public TreatmentScheduleServiceImpl(TreatmentScheduleRepository treatmentScheduleRepository) {
        this.treatmentScheduleRepository = treatmentScheduleRepository;
    }

    @Override
    public List<TreatmentScheduleResponse> getAll() {
        return StreamSupport.stream(treatmentScheduleRepository.findAll().spliterator(), false)
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<TreatmentScheduleResponse> getTreatment(int treatmentId) {
        return StreamSupport.stream(treatmentScheduleRepository.findAll().spliterator(), false)
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getTreatment() == treatmentId)
                .collect(Collectors.toList());
    }

    @Override
    public void updateTreatmentSchedule(int treatmentId, Date date, Time timeFrom, Time timeTo) {
        Optional<TreatmentSchedule> treatmentSchedule = treatmentScheduleRepository.findById(treatmentId);
        treatmentSchedule.ifPresent(treatmentSchedule1 -> {
            treatmentSchedule1.setDate(date);
            treatmentSchedule1.setTime_from(timeFrom);
            treatmentSchedule1.setTime_to(timeTo);
        });
        treatmentScheduleRepository.save(treatmentSchedule.get());
    }
}
