package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.TimeOff;
import com.csidigital.rh.dao.repository.TimeOffRepository;
import com.csidigital.rh.management.service.TimeOffService;
import com.csidigital.rh.shared.dto.request.TimeOffRequest;
import com.csidigital.rh.shared.dto.response.TimeOffResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TimeOffImpl implements TimeOffService {
    @Autowired
    private TimeOffRepository timeOffRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TimeOffResponse createTimeOff(TimeOffRequest request) {
        TimeOff timeOff = modelMapper.map(request, TimeOff.class);
        TimeOff TimeOffSaved = timeOffRepository.save(timeOff);
        return modelMapper.map(TimeOffSaved, TimeOffResponse.class);
    }

    @Override
    public List<TimeOffResponse> getAllTimeOff() {
        List<TimeOff> timeOff = timeOffRepository.findAll();
        List<TimeOffResponse> timeOffList = new ArrayList<>();


        for (TimeOff timeOff1: timeOff) {
            TimeOffResponse response = modelMapper.map(timeOff1, TimeOffResponse.class);
            timeOffList.add(response);
        }

        return timeOffList;
    }

    @Override
    public TimeOffResponse getTimeOffById(Long id) {
        TimeOff timeOff =timeOffRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("TimeOff with id " +id+ " not found"));
        TimeOffResponse timeOffResponse = modelMapper.map(timeOff, TimeOffResponse.class);
        return timeOffResponse;
    }

    @Override
    public TimeOffResponse updateTimeOff(TimeOffRequest request, Long id) {
        TimeOff existingTimeOff = timeOffRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("TimeOff with id: " + id + " not found"));
        modelMapper.map(request, existingTimeOff);
        TimeOff savedTimeOff = timeOffRepository.save(existingTimeOff);
        return modelMapper.map(savedTimeOff, TimeOffResponse.class);
    }

    @Override
    public void deleteTimeOff(Long id) {
        timeOffRepository.deleteById(id);
    }
}
