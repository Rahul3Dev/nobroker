package com.nobroker.service.impl;
import com.nobroker.entity.OwnerPlan;
import com.nobroker.payload.OwnerPlanDto;
import com.nobroker.repository.OwnerPlanRepository;
import com.nobroker.service.OwnerPlanService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerPlanServiceImpl implements OwnerPlanService {
    private OwnerPlanRepository ownerPlanRepository;
    @Autowired
    private ModelMapper modelMapper;

    public OwnerPlanServiceImpl(OwnerPlanRepository ownerPlanRepository, ModelMapper modelMapper) {
        this.ownerPlanRepository = ownerPlanRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerPlanDto CreateOwnerPlans(OwnerPlanDto ownerPlanDto) {
        OwnerPlan ownerPlan = mapToEntity(ownerPlanDto);
        OwnerPlan savedOwnerPlan = ownerPlanRepository.save(ownerPlan);
       return mapToDto(savedOwnerPlan);

    }

    @Override
    public List<OwnerPlanDto> getAllOwnerlans() {
        List<OwnerPlan> ownerPlans = ownerPlanRepository.findAll();
        List<OwnerPlanDto> ownerPlansDtos = ownerPlans.stream().map(plan -> mapToDto(plan)).collect(Collectors.toList());
        return ownerPlansDtos;
    }


    OwnerPlan mapToEntity(OwnerPlanDto ownerPlanDto){
        OwnerPlan ownerPlan = modelMapper.map(ownerPlanDto, OwnerPlan.class);
        return ownerPlan;
    }

    OwnerPlanDto mapToDto(OwnerPlan ownerPlan) {
        OwnerPlanDto ownerPlanDto = modelMapper.map(ownerPlan, OwnerPlanDto.class);
        return ownerPlanDto;
    }

}
