package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.EducationImpl;
import com.csidigital.rh.shared.dto.request.EducationRequest;
import com.csidigital.rh.shared.dto.response.EducationResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/education")
public class EducationController {
    @Autowired
    private EducationImpl EducationService ;

    @GetMapping("/getEducations")
    public List<EducationResponse> getAllEducations() {
        return EducationService.getAllEducations();
    }

    @GetMapping("/get/{id}")
    public EducationResponse getEducationById(@PathVariable Long id){
        return EducationService.getEducationById(id);
    }

    @PostMapping("/add")
    public EducationResponse createEducation(@Valid @RequestBody EducationRequest educationRequest){
        return EducationService.createEducation(educationRequest);
    }

    @PutMapping("/update/{id}")
    public EducationResponse updateEducation(@Valid @RequestBody EducationRequest educationRequest,
                                         @PathVariable Long id){
        return EducationService.updateEducation(educationRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEducation(@PathVariable Long id){
        EducationService.deleteEducation(id);
    }

}
