package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.TimeOffRequest;
import com.csidigital.rh.shared.dto.response.TimeOffResponse;

import java.util.List;

public interface TimeOffService {

    TimeOffResponse createTimeOff(TimeOffRequest request);
    List<TimeOffResponse> getAllTimeOff();
    TimeOffResponse getTimeOffById(Long id);

    TimeOffResponse updateTimeOff(TimeOffRequest request, Long id);

    void deleteTimeOff(Long id);

}
