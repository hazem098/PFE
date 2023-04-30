package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.dao.repository.ArticleRepository;
import com.csidigital.rh.dao.repository.AssContractArticleRepository;
import com.csidigital.rh.dao.repository.ContractRepository;
import com.csidigital.rh.management.service.AssContractArticleService;
import com.csidigital.rh.shared.dto.request.AssContractArticleRequest;
import com.csidigital.rh.shared.dto.response.AssContractArticleResponse;
import com.csidigital.rh.shared.dto.response.AssOfferCandidateResponse;
import com.csidigital.rh.shared.dto.response.OfferResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssContractArticleImpl implements AssContractArticleService {
    @Autowired
    private AssContractArticleRepository assContractArticleRepository;
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AssContractArticleResponse createAssContractArticle(AssContractArticleRequest request) {
        Contract contract = contractRepository.findById(request.getContractId())
                .orElseThrow(() -> new ResourceNotFoundException("Contract with id " + request.getContractId() + " not found"));

        Article article = articleRepository.findById(request.getArticleId())
                .orElseThrow(() -> new ResourceNotFoundException("Article with id " + request.getArticleId() + " not found"));

        AssContractArticle assContractArticle = new AssContractArticle();
        assContractArticle.setContract(contract);
        assContractArticle.setArticle(article);

        AssContractArticle createdAssContractArticle = assContractArticleRepository.save(assContractArticle);

        return modelMapper.map(createdAssContractArticle, AssContractArticleResponse.class);
    }


    @Override
    public List<AssContractArticleResponse> getAllAssContractArticle() {
        List<AssContractArticle> assContractArticleList = assContractArticleRepository.findAll();
        List<AssContractArticleResponse> assContractArticleResponseList = new ArrayList<>();

        for (AssContractArticle assContractArticle : assContractArticleList) {
            assContractArticleResponseList.add(modelMapper.map(assContractArticle, AssContractArticleResponse.class));
        }

        return assContractArticleResponseList;

    }

    @Override
    public AssContractArticleResponse getAssContractArticleById(Long id) {
        AssContractArticle assContractArticle =assContractArticleRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("AssContractArticle with id " +id+ " not found"));
        AssContractArticleResponse assContractArticleResponse = modelMapper.map(assContractArticle,AssContractArticleResponse .class);
        return assContractArticleResponse;
    }

    @Override
    public AssContractArticleResponse updateAssContractArticle(AssContractArticleRequest request, Long id) {

            AssContractArticle assContractArticle = assContractArticleRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("AssContractArticle with id " + id + " not found"));

            Contract contract = contractRepository.findById(request.getContractId())
                    .orElseThrow(() -> new ResourceNotFoundException("Contract with id " + request.getContractId() + " not found"));

            Article article = articleRepository.findById(request.getArticleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Article with id " + request.getArticleId() + " not found"));

            assContractArticle.setContract(contract);
            assContractArticle.setArticle(article);

            AssContractArticle updatedAssContractArticle = assContractArticleRepository.save(assContractArticle);

            return modelMapper.map(updatedAssContractArticle, AssContractArticleResponse.class);
    }

    @Override
    public void deleteAssContractArticle(Long id) {
        assContractArticleRepository.deleteById(id);

    }
}
