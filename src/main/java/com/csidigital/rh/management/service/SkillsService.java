package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.Skills;
import com.csidigital.rh.shared.dto.request.SkillsCategoryRequest;
import com.csidigital.rh.shared.dto.request.SkillsRequest;
import com.csidigital.rh.shared.dto.response.SkillsCategoryResponse;
import com.csidigital.rh.shared.dto.response.SkillsResponse;

import java.util.List;

public interface SkillsService {
    SkillsResponse createSkills(SkillsRequest request);
    List<SkillsResponse> getAllSkills();
    SkillsResponse getSkillsById(Long id);

    SkillsResponse updateSkills(SkillsRequest request, Long id);

    void deleteSkills(Long id);
}
