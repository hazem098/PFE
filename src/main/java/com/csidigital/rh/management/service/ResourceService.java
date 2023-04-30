package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.request.ResourceRequest;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
import com.csidigital.rh.shared.dto.response.ResourceResponse;

import java.util.List;

public interface ResourceService {
    ResourceResponse createResource(ResourceRequest request);
    List<ResourceResponse> getAllResources();
    ResourceResponse getResourceById(Long id);

    ResourceResponse updateResource(ResourceRequest request, Long id);

    void deleteResource(Long id);
}
