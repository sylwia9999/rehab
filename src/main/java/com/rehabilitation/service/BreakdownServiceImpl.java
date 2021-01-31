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
                .filter(breakdownResponse -> ((breakdownResponse.getDate_from().before(date) || breakdownResponse.getDate_from().equals(date)) && ( breakdownResponse.getDate_to().equals(date) || breakdownResponse.getDate_to() == null)))
                .collect(Collectors.toList());
    }

    @Override
    public List<BreakdownResponse> getActiveBreakdowns(Date date) {
        return StreamSupport.stream(breakdownRepository.findAll().spliterator(), false)
                .map(breakdown -> new BreakdownResponse(breakdown.getBreakdownId(), breakdown.getDate_from(), breakdown.getDate_to(), breakdown.getMachine().getMachine_id()))
                .filter(breakdownResponse -> ((breakdownResponse.getDate_from().before(date) || breakdownResponse.getDate_from().equals(date)) && ( breakdownResponse.getDate_to().equals(date) || breakdownResponse.getDate_to() == null)))
                .collect(Collectors.toList());
    }
}
