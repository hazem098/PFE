package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.ResourceRequest;
import com.csidigital.rh.shared.dto.request.SkillsCategoryRequest;
import com.csidigital.rh.shared.dto.response.ResourceResponse;
import com.csidigital.rh.shared.dto.response.SkillsCategoryResponse;

import java.util.List;

public interface SkillsCategoryService {
    SkillsCategoryResponse createSkillsCategory(SkillsCategoryRequest request);
    List<SkillsCategoryResponse> getAllSkillsCategories();
    SkillsCategoryResponse getSkillsCategoryById(Long id);

    SkillsCategoryResponse updateSkillsCategory(SkillsCategoryRequest request, Long id);

    void deleteSkillsCategory(Long id);
}
