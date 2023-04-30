package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.EducationRequest;
import com.csidigital.rh.shared.dto.response.EducationResponse;

import java.util.List;

public interface EducationService {
    EducationResponse createEducation(EducationRequest request);
    List<EducationResponse> getAllEducations();
    EducationResponse getEducationById(Long id);

    EducationResponse updateEducation(EducationRequest request, Long id);

    void deleteEducation(Long id);
}
