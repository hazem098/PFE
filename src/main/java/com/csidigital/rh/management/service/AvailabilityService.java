package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.AvailabilityRequest;
import com.csidigital.rh.shared.dto.response.AvailabilityResponse;

import java.util.List;

public interface AvailabilityService {
   AvailabilityResponse createAvailability(AvailabilityRequest request);
    List<AvailabilityResponse> getAllAvailability();
    AvailabilityResponse getAvailabilityById(Long id);

    AvailabilityResponse updateAvailability(AvailabilityRequest request, Long id);

    void deleteAvailability(Long id);

}
