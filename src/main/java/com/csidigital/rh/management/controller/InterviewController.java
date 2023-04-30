package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.InterviewImpl;

import com.csidigital.rh.shared.dto.request.InterviewRequest;
import com.csidigital.rh.shared.dto.response.InterviewResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("rh/Interview")

public class InterviewController {
    @Autowired
    private InterviewImpl interviewImpl ;

    @GetMapping("getAll")
    public List<InterviewResponse> getAllInterview() {
        return interviewImpl.getAllInterview();
    }

    @GetMapping("/getBy/{id}")
    public InterviewResponse getInterviewById(@PathVariable Long id){
        return interviewImpl.getInterviewById(id);
    }

    @PostMapping("/add")
    public InterviewResponse createInterview(@Valid @RequestBody InterviewRequest interviewRequest){
        return interviewImpl.createInterview(interviewRequest);
    }

    @PutMapping("/update/{id}")
    public InterviewResponse updateInterview(@Valid @RequestBody InterviewRequest interviewRequest,
                                                   @PathVariable Long id){
        return interviewImpl.updateInterview(interviewRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInterview(@PathVariable Long id){
        interviewImpl.deleteInterview(id);
    }

}
