package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.dao.repository.*;
import com.csidigital.rh.management.service.AssOfferCandidateService;
import com.csidigital.rh.shared.dto.request.AssOfferCandidateRequest;
import com.csidigital.rh.shared.dto.response.AssOfferCandidateResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class AssOfferCandidateImpl implements AssOfferCandidateService {
    @Autowired
    private AssOfferCandidateRepository assOfferCandidateRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Override
    public AssOfferCandidateResponse createAssOfferCandidate(AssOfferCandidateRequest request) {
        Evaluation evaluation = null ;
        if (request.getEvaluationNum()!= null){
            evaluation = evaluationRepository.findById(request.getEvaluationNum()).orElseThrow();}
        Offer offer = offerRepository.findById(request.getOfferNum()).orElseThrow();
        Employee employee = employeeRepository.findById(request.getEmployeeNum()).orElseThrow();
        OfferCandidate offerCandidate = modelMapper.map(request, OfferCandidate.class);
        offerCandidate.setEmployee(employee);
        offerCandidate.setOffer(offer);
        offerCandidate.setEvaluation(evaluation);
        OfferCandidate offerCandidateSaved = assOfferCandidateRepository.save(offerCandidate);
        return modelMapper.map(offerCandidateSaved, AssOfferCandidateResponse.class);
    }

    @Override
    public List<AssOfferCandidateResponse> getAllAssOfferCandidate() {
        List<OfferCandidate> offerCandidate = assOfferCandidateRepository.findAll();
        List<AssOfferCandidateResponse> assOfferCandidateList = new ArrayList<>();


        for (OfferCandidate offerCandidate1 : offerCandidate) {
            AssOfferCandidateResponse response = modelMapper.map(offerCandidate1, AssOfferCandidateResponse.class);
            assOfferCandidateList.add(response);
        }

        return assOfferCandidateList;
    }

    @Override
    public AssOfferCandidateResponse getAssOfferCandidateById(Long id) {
        OfferCandidate offerCandidate =assOfferCandidateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("AssOfferCandidate with id " +id+ " not found"));
        AssOfferCandidateResponse assOfferCandidateResponse = modelMapper.map(offerCandidate, AssOfferCandidateResponse.class);
        return assOfferCandidateResponse;
    }

    @Override
    public AssOfferCandidateResponse updateAssOfferCandidate(AssOfferCandidateRequest request, Long id) {
        OfferCandidate existingOfferCandidate = assOfferCandidateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("AssOfferCandidate with id: " + id + " not found"));
        modelMapper.map(request, existingOfferCandidate);
        OfferCandidate savedOfferCandidate = assOfferCandidateRepository.save(existingOfferCandidate);
        return modelMapper.map(savedOfferCandidate, AssOfferCandidateResponse.class);
    }

    @Override
    public void deleteAssOfferCandidate(Long id) {
        assOfferCandidateRepository.deleteById(id);
    }

}
