package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.BackOfficeRequest;
import com.csidigital.rh.shared.dto.request.CandidateRequest;
import com.csidigital.rh.shared.dto.response.BackOfficeResponse;
import com.csidigital.rh.shared.dto.response.CandidateResponse;

import java.util.List;

public interface CandidateService {
    CandidateResponse createCandidate(CandidateRequest request);
    List<CandidateResponse> getAllCandidates();
    CandidateResponse getCandidateById(Long id);

    CandidateResponse updateCandidate(CandidateRequest request, Long id);

    void deleteCandidate(Long id);
}
