package com.rehabilitation.service;

import com.rehabilitation.Dto.BreakdownResponse;

import java.sql.Date;
import java.util.List;

public interface BreakdownService {
    List<BreakdownResponse> getAll();
    List<BreakdownResponse> getActiveBreakdownForMachine(int machineId, Date date);
    List<BreakdownResponse> getActiveBreakdowns(Date date);
}
