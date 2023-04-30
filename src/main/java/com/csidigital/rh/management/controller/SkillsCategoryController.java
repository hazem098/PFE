package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.ResourceContractImpl;
import com.csidigital.rh.management.service.impl.SkillsCategoryImpl;
import com.csidigital.rh.shared.dto.request.ResourceContractRequest;
import com.csidigital.rh.shared.dto.request.SkillsCategoryRequest;
import com.csidigital.rh.shared.dto.response.ResourceContractResponse;
import com.csidigital.rh.shared.dto.response.SkillsCategoryResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/skillsCategory")
public class SkillsCategoryController {
    @Autowired
    private SkillsCategoryImpl skillsCategory;

    @GetMapping("/getAll")
    public List<SkillsCategoryResponse > getAllSkillsCategories(){
        return skillsCategory.getAllSkillsCategories();
    }

    @GetMapping("/getSkillsCategory/{id}")
    public SkillsCategoryResponse getSkillsCategoryById(@PathVariable Long id){
        return skillsCategory.getSkillsCategoryById(id);
    }

    @PostMapping("/addSkillsCategory")
    public SkillsCategoryResponse createSkillsCategory(@Valid @RequestBody SkillsCategoryRequest skillsCategoryRequest){
        return skillsCategory.createSkillsCategory(skillsCategoryRequest);
    }

    @PutMapping("/updateSkillsCategory/{id}")
    public SkillsCategoryResponse updateSkillsCategory(@Valid @RequestBody SkillsCategoryRequest skillsCategoryRequest,
                                                           @PathVariable Long id){
        return skillsCategory.updateSkillsCategory(skillsCategoryRequest, id);
    }

    @DeleteMapping("/deleteSkillsCategory/{id}")
    public void deleteSkillsCategory(@PathVariable Long id){
        skillsCategory.deleteSkillsCategory(id);
    }
}
