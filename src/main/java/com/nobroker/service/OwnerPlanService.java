package com.nobroker.service;

import com.nobroker.payload.OwnerPlanDto;

import java.util.List;

public interface OwnerPlanService {

    public OwnerPlanDto CreateOwnerPlans(OwnerPlanDto ownerPlanDto);

    List<OwnerPlanDto> getAllOwnerlans();
}
