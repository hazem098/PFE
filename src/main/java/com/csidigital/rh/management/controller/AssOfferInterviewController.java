package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.AssQuestionInterviewImpl;
import com.csidigital.rh.management.service.impl.AssQuestionInterviewImpl;
import com.csidigital.rh.shared.dto.request.AssQuestionInterviewRequest;
import com.csidigital.rh.shared.dto.response.AssQuestionInterviewResponse;
import com.csidigital.rh.shared.dto.response.AssQuestionInterviewResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional
@RestController
@RequestMapping("/rh/AssQuestionInterview")
public class AssOfferInterviewController {
    @Autowired
    private AssQuestionInterviewImpl assQuestionInterview;

    @GetMapping("/getAll")
    public List<AssQuestionInterviewResponse> getAllAssQuestionInterview(){
        return assQuestionInterview.getAllAssQuestionInterview();
    }

    @GetMapping("/getAss/{id}")
    public AssQuestionInterviewResponse getAssQuestionInterviewById(@PathVariable Long id){
        return assQuestionInterview.getAssQuestionInterviewDataById(id);
    }

    @PostMapping("/addAss")
    public AssQuestionInterviewResponse createAssQuestionInterview(@Valid @RequestBody AssQuestionInterviewRequest assQuestionInterviewRequest){
        return assQuestionInterview.createAssQuestionInterview(assQuestionInterviewRequest);
    }

    @PutMapping("/update/{id}")
    public AssQuestionInterviewResponse updateAssQuestionInterview(@Valid @RequestBody AssQuestionInterviewRequest assQuestionInterviewRequest,
                                                        @PathVariable Long id){
        return assQuestionInterview.updateAssQuestionInterview(assQuestionInterviewRequest, id);
    }

    @DeleteMapping("/deleteAss/{id}")
    public void deleteAssQuestionInterview(@PathVariable Long id){
        assQuestionInterview.deleteAssQuestionInterviewData(id);
    }


}
