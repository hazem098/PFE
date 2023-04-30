package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Candidate;
import com.csidigital.rh.dao.entity.Offer;
import com.csidigital.rh.dao.repository.CandidateRepository;
import com.csidigital.rh.dao.repository.OfferRepository;
import com.csidigital.rh.management.service.CandidateService;
import com.csidigital.rh.shared.dto.request.CandidateRequest;
import com.csidigital.rh.shared.dto.response.CandidateResponse;
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
public class CandidateImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CandidateResponse createCandidate(CandidateRequest request) {
        Candidate candidate = modelMapper.map(request, Candidate.class);

        // find offers by their ids and add them to the candidate
        /*List<Offer> offers = offerRepository.findAllById(request.getOfferIds));*/
        /*candidate.setOfferList(offers);*/

        Candidate candidateSaved = candidateRepository.save(candidate);
        return modelMapper.map(candidateSaved, CandidateResponse.class);
    }

    @Override
    public List<CandidateResponse> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateResponse> candidateResponseList = new ArrayList<>();

        for (Candidate candidate : candidates) {
            CandidateResponse response = modelMapper.map(candidate, CandidateResponse.class);
            candidateResponseList.add(response);
        }

        return candidateResponseList;
    }

    @Override
    public CandidateResponse getCandidateById(Long id) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with id " + id + " not found"));
        CandidateResponse candidateResponse = modelMapper.map(candidate, CandidateResponse.class);
        return candidateResponse;
    }

    @Override
    public CandidateResponse updateCandidate(CandidateRequest request, Long id) {
        Candidate existingCandidate = candidateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Candidate with id: " + id + " not found"));
        modelMapper.map(request, existingCandidate);
        Candidate savedCandidate = candidateRepository.save(existingCandidate);
        return modelMapper.map(savedCandidate, CandidateResponse.class);
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
