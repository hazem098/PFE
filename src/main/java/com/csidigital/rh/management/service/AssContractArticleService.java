package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.AssContractArticleRequest;
import com.csidigital.rh.shared.dto.request.AssOfferCandidateRequest;
import com.csidigital.rh.shared.dto.response.AssContractArticleResponse;
import com.csidigital.rh.shared.dto.response.AssOfferCandidateResponse;

import java.util.List;

public interface AssContractArticleService {
    AssContractArticleResponse createAssContractArticle(AssContractArticleRequest request);
    List<AssContractArticleResponse> getAllAssContractArticle();
    AssContractArticleResponse getAssContractArticleById(Long id);

    AssContractArticleResponse updateAssContractArticle(AssContractArticleRequest request, Long id);

    void deleteAssContractArticle(Long id);
}
