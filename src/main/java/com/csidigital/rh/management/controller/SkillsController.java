package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.Skills;
import com.csidigital.rh.management.service.impl.SkillsCategoryImpl;
import com.csidigital.rh.management.service.impl.SkillsImpl;
import com.csidigital.rh.shared.dto.request.SkillsCategoryRequest;
import com.csidigital.rh.shared.dto.request.SkillsRequest;
import com.csidigital.rh.shared.dto.response.SkillsCategoryResponse;
import com.csidigital.rh.shared.dto.response.SkillsResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/skills")
public class SkillsController {
    @Autowired
    private SkillsImpl skills;

    @GetMapping("/getAll")
    public List<SkillsResponse> getAllSkills(){
        return skills.getAllSkills();
    }

    @GetMapping("/getSkills/{id}")
    public SkillsResponse getSkillsById(@PathVariable Long id){
        return skills.getSkillsById(id);
    }

    @PostMapping("/addSkills")
    public SkillsResponse createSkills(@Valid @RequestBody SkillsRequest skillsRequest){
        return skills.createSkills(skillsRequest);
    }

    @PutMapping("/updateSkills/{id}")
    public SkillsResponse updateSkills(@Valid @RequestBody SkillsRequest skillsRequest,
                                                       @PathVariable Long id){
        return skills.updateSkills(skillsRequest, id);
    }

    @DeleteMapping("/deleteSkills/{id}")
    public void deleteSkills(@PathVariable Long id){
        skills.deleteSkills(id);
    }
}
