package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.AssOfferCandidateImpl;
import com.csidigital.rh.shared.dto.request.AssOfferCandidateRequest;
import com.csidigital.rh.shared.dto.response.AssOfferCandidateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rh/AssOfferCandidate")
public class AssOfferCandidateController {
    @Autowired
    private AssOfferCandidateImpl assOfferCandidateImpl ;

    @GetMapping("getAll")
    public List<AssOfferCandidateResponse> getAllAssOfferCandidate() {
        return assOfferCandidateImpl.getAllAssOfferCandidate();
    }

    @GetMapping("/getBy/{id}")
    public AssOfferCandidateResponse getAssOfferCandidateById(@PathVariable Long id){
        return assOfferCandidateImpl.getAssOfferCandidateById(id);
    }

    @PostMapping("/add")
    public AssOfferCandidateResponse createAssOfferCandidate(@Valid @RequestBody AssOfferCandidateRequest assOfferCandidateRequest){
        return assOfferCandidateImpl.createAssOfferCandidate(assOfferCandidateRequest);
    }

    @PutMapping("/update/{id}")
    public AssOfferCandidateResponse updateAssOfferCandidate(@Valid @RequestBody AssOfferCandidateRequest assOfferCandidateRequest,
                                                   @PathVariable Long id){
        return assOfferCandidateImpl.updateAssOfferCandidate(assOfferCandidateRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssOfferCandidate(@PathVariable Long id){
        assOfferCandidateImpl.deleteAssOfferCandidate(id);
    }

}
