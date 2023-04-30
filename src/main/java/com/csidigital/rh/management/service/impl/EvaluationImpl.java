package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Evaluation;
import com.csidigital.rh.dao.entity.OfferCandidate;
import com.csidigital.rh.dao.repository.AssOfferCandidateRepository;
import com.csidigital.rh.dao.repository.EvaluationRepository;
import com.csidigital.rh.management.service.EvaluationService;
import com.csidigital.rh.shared.dto.request.EvaluationRequest;
import com.csidigital.rh.shared.dto.response.EvaluationResponse;
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
public class EvaluationImpl implements EvaluationService {
   @Autowired 
   private EvaluationRepository evaluationRepository ; 
   @Autowired 
   private ModelMapper modelMapper ;
   @Autowired
   private AssOfferCandidateRepository offerCandidateRepository;
    @Override
    public EvaluationResponse createEvaluation(EvaluationRequest request) {
        OfferCandidate offerCandidate = offerCandidateRepository.findById(request.getOfferCandidateId()).orElseThrow();
        Evaluation evaluation = modelMapper.map(request, Evaluation.class);
        Evaluation evaluationSaved = evaluationRepository.save(evaluation);
        evaluation.setOfferCandidate(offerCandidate);
        return modelMapper.map(evaluationSaved, EvaluationResponse.class);
    }

    @Override
    public List<EvaluationResponse> getAllEvaluations() {
        List<Evaluation> evaluations = evaluationRepository.findAll();
        List<EvaluationResponse> evaluationList = new ArrayList<>();

        for (Evaluation evaluation : evaluations) {
            EvaluationResponse response = modelMapper.map(evaluation, EvaluationResponse.class);
            evaluationList.add(response);
        }

        return evaluationList;
    }

    @Override
    public EvaluationResponse getEvaluationById(Long id) {
        Evaluation evaluation = evaluationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Evaluation with id " +id+ " not found"));
        EvaluationResponse evaluationResponse = modelMapper.map(evaluation, EvaluationResponse.class);
        return evaluationResponse;
    }

    @Override
    public EvaluationResponse updateEvaluation(EvaluationRequest request, Long id) {
        Evaluation existingEvaluation = evaluationRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Evaluation with id: " + id + " not found"));
        modelMapper.map(request, existingEvaluation);
        Evaluation savedEvaluation = evaluationRepository.save(existingEvaluation);
        return modelMapper.map(savedEvaluation, EvaluationResponse.class);
    }

    @Override
    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }
}
