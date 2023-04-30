package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.ExternalResourceRequest;
import com.csidigital.rh.shared.dto.response.ExternalResourceResponse;

import java.util.List;

public interface ExternalResourceService {
    ExternalResourceResponse createExternalResource(ExternalResourceRequest request);
    List<ExternalResourceResponse> getAllExternalResource();
    ExternalResourceResponse getExternalResourceById(Long id);

    ExternalResourceResponse updateExternalResource(ExternalResourceRequest request, Long id);

    void deleteExternalResource(Long id);

}
