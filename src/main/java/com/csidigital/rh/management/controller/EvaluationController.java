package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.EvaluationImpl;
import com.csidigital.rh.shared.dto.request.EvaluationRequest;
import com.csidigital.rh.shared.dto.response.EvaluationResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/evaluation")

public class EvaluationController {
    @Autowired
    private EvaluationImpl EvaluationService ;

    @GetMapping("/getEvaluations")
    public List<EvaluationResponse> getAllEvaluations() {
        return EvaluationService.getAllEvaluations();
    }

    @GetMapping("/get/{id}")
    public EvaluationResponse getEvaluationById(@PathVariable Long id){
        return EvaluationService.getEvaluationById(id);
    }

    @PostMapping("/add")
    public EvaluationResponse createEvaluation(@Valid @RequestBody EvaluationRequest evaluationRequest){
        return EvaluationService.createEvaluation(evaluationRequest);
    }

    @PutMapping("/update/{id}")
    public EvaluationResponse updateEvaluation(@Valid @RequestBody EvaluationRequest evaluationRequest,
                                         @PathVariable Long id){
        return EvaluationService.updateEvaluation(evaluationRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvaluation(@PathVariable Long id){
        EvaluationService.deleteEvaluation(id);
    }

}
