package com.rehabilitation.service;

import com.rehabilitation.Dto.TreatmentScheduleResponse;
import com.rehabilitation.Dto.WorkerScheduleResponse;
import com.rehabilitation.repository.TreatmentRepository;
import com.rehabilitation.repository.TreatmentScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TreatmentScheduleServiceImpl implements TreatmentScheduleService {
    private final TreatmentScheduleRepository treatmentScheduleRepository;
    private final TreatmentRepository treatmentRepository;
    private final WorkerScheduleServiceImpl workerScheduleService;
    private static final Logger LOGGER;
    static {
        LOGGER = LoggerFactory.getLogger(TreatmentServiceImpl.class);
    }

    @Autowired
    public TreatmentScheduleServiceImpl(TreatmentScheduleRepository treatmentScheduleRepository, TreatmentRepository treatmentRepository, WorkerScheduleServiceImpl workerScheduleService) {
        this.treatmentScheduleRepository = treatmentScheduleRepository;
        this.treatmentRepository = treatmentRepository;
        this.workerScheduleService = workerScheduleService;
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
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getDate(), treatmentSchedule.getTime_from(), treatmentSchedule.getTime_to(), treatmentSchedule.getWorker().getUserId(), treatmentSchedule.getLocation().getLocationId(), treatmentSchedule.getMachine().getMachine_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getTreatment() == treatmentId)
                .collect(Collectors.toList());
    }

    @Override
    public List<TreatmentScheduleResponse> getMachine(int machineId, Date date) {
        return StreamSupport.stream(treatmentScheduleRepository.findAll().spliterator(), false)
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getDate(), treatmentSchedule.getTime_from(), treatmentSchedule.getTime_to(), treatmentSchedule.getWorker().getUserId(), treatmentSchedule.getLocation().getLocationId(), treatmentSchedule.getMachine().getMachine_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getMachine() == machineId)
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<TreatmentScheduleResponse> getWorker(Long workerId, Date date) {
        return StreamSupport.stream(treatmentScheduleRepository.findAll().spliterator(), false)
                .map(treatmentSchedule -> new TreatmentScheduleResponse(treatmentSchedule.getTreatment_schedule_id(), treatmentSchedule.getDate(), treatmentSchedule.getTime_from(), treatmentSchedule.getTime_to(), treatmentSchedule.getWorker().getUserId(), treatmentSchedule.getLocation().getLocationId(), treatmentSchedule.getMachine().getMachine_id(), treatmentSchedule.getTreatment().getTreatment_id()))
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getUser() == workerId)
                .filter(treatmentScheduleResponse -> treatmentScheduleResponse.getDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Time> getHours(int machineId, Date date, Time openTime, Time closeTime, int duration) {
        List<Time> possibleHours = new ArrayList<>();
        List<TreatmentScheduleResponse> schedules = getMachine(machineId, date);
        Time time;
        int i = 1;
        do {
            time = Time.valueOf(openTime.toLocalTime().plusMinutes(15L * i));
            possibleHours.add(time);
            i++;
        } while (time.before(Time.valueOf(closeTime.toLocalTime().minusMinutes(duration+5))));
        for (TreatmentScheduleResponse response : schedules) {
            possibleHours.removeIf(possibleHour -> possibleHour.after(Time.valueOf(response.getTimeFrom().toLocalTime().minusMinutes(duration + 5)))
                    && possibleHour.before(Time.valueOf(response.getTimeTo().toLocalTime().plusMinutes(5))));
        }
        return possibleHours;
    }

    @Override
    public List<Time> getHoursWorker(Long workerId, Date date, int duration) {
        List<Time> possibleHours = new ArrayList<>();
        List<TreatmentScheduleResponse> schedules = getWorker(workerId, date);
        List<WorkerScheduleResponse> workerScheduleResponses = workerScheduleService.getWorker(workerId, date);
        Time startTime = workerScheduleResponses.get(0).getTime_from();
        Time endTime = workerScheduleResponses.get(0).getTime_to();
        Time time;
        int i = 1;
        do {
            time = Time.valueOf(startTime.toLocalTime().plusMinutes(15L * i));
            possibleHours.add(time);
            i++;
        } while (time.before(Time.valueOf(endTime.toLocalTime().minusMinutes(duration+5))));
        for (TreatmentScheduleResponse response : schedules) {
            possibleHours.removeIf(possibleHour -> possibleHour.after(Time.valueOf(response.getTimeFrom().toLocalTime().minusMinutes(duration + 5)))
                    && possibleHour.before(Time.valueOf(response.getTimeTo().toLocalTime().plusMinutes(5))));
        }
        return possibleHours;
    }

}
