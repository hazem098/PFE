package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.ExperienceService;
import com.csidigital.rh.shared.dto.request.ExperienceRequest;
import com.csidigital.rh.shared.dto.response.ExperienceResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/experience")
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService ;
    @GetMapping("/getExperiences")
    public List<ExperienceResponse> getAllExperiences() {
        return experienceService.getAllExperiences();
    }

    @GetMapping("/get/{id}")
    public ExperienceResponse getExperienceById(@PathVariable Long id){
        return experienceService.getExperienceById(id);
    }

    @PostMapping("/add")
    public ExperienceResponse createExperience(@Valid @RequestBody ExperienceRequest experienceRequest){
        return experienceService.createExperience(experienceRequest);
    }

    @PutMapping("/update/{id}")
    public ExperienceResponse updateExperience(@Valid @RequestBody ExperienceRequest experienceRequest,
                                         @PathVariable Long id){
        return experienceService.updateExperience(experienceRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
    }

}
