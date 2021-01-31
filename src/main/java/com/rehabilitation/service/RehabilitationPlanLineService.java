package com.rehabilitation.service;

import com.rehabilitation.Dto.RehabilitationPlanLineResponse;
import java.util.List;

public interface RehabilitationPlanLineService {
    List<RehabilitationPlanLineResponse> getAll();
    List<RehabilitationPlanLineResponse> getPlanId(int planId);
}
