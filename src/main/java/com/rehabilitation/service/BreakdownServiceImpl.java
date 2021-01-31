package com.rehabilitation.service;

import com.rehabilitation.Dto.BreakdownResponse;
import com.rehabilitation.repository.BreakdownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BreakdownServiceImpl implements BreakdownService {
    private final BreakdownRepository breakdownRepository;

    @Autowired
    public BreakdownServiceImpl(BreakdownRepository breakdownRepository) {
        this.breakdownRepository = breakdownRepository;
    }

    @Override
    public List<BreakdownResponse> getAll() {
        return StreamSupport.stream(breakdownRepository.findAll().spliterator(), false)
                .map(breakdown -> new BreakdownResponse(breakdown.getBreakdownId(), breakdown.getDate_from(), breakdown.getDate_to(), breakdown.getMachine().getMachine_id()))
                .collect(Collectors.toList());
    }

    @Override
    public List<BreakdownResponse> getActiveBreakdownForMachine(int machineId, Date date) {
        return StreamSupport.stream(breakdownRepository.findAll().spliterator(), false)
                .map(breakdown -> new BreakdownResponse(breakdown.getBreakdownId(), breakdown.getDate_from(), breakdown.getDate_to(), breakdown.getMachine().getMachine_id()))
                .filter(breakdownResponse -> breakdownResponse.getMachine() == machineId)
                .filter(breakdownResponse -> {
                    if ((!breakdownResponse.getDate_from().before(date) && !breakdownResponse.getDate_from().equals(date)))
                        return false;
                    else if((breakdownResponse.getDate_to().filter(date1 -> date1.after(date) || date1.equals(date)).isPresent())
                        || !breakdownResponse.getDate_to().isPresent())
                        return true;
                    else return false;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<BreakdownResponse> getActiveBreakdowns(Date date) {
        return StreamSupport.stream(breakdownRepository.findAll().spliterator(), false)
                .map(breakdown -> new BreakdownResponse(breakdown.getBreakdownId(), breakdown.getDate_from(), breakdown.getDate_to(), breakdown.getMachine().getMachine_id()))
                .filter(breakdownResponse -> {
                    if ((!breakdownResponse.getDate_from().before(date) && !breakdownResponse.getDate_from().equals(date)))
                        return false;
                    else if((breakdownResponse.getDate_to().filter(date1 -> date1.after(date) || date1.equals(date)).isPresent())
                            || !breakdownResponse.getDate_to().isPresent())
                        return true;
                    else return false;
                })
                .collect(Collectors.toList());
    }
}
