package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.AssContractArticleImpl;
import com.csidigital.rh.shared.dto.request.AssContractArticleRequest;
import com.csidigital.rh.shared.dto.request.AssOfferCandidateRequest;
import com.csidigital.rh.shared.dto.response.AssContractArticleResponse;
import com.csidigital.rh.shared.dto.response.AssOfferCandidateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/assContractArticle")
public class AssContractArticleController {

    @Autowired
    private AssContractArticleImpl assContractArticleImpl;
    @GetMapping("getAll")
    public List<AssContractArticleResponse> getAllAssContractArticle() {
        return assContractArticleImpl.getAllAssContractArticle();
    }

    @GetMapping("/getBy/{id}")
    public AssContractArticleResponse getAssOfferCandidateById(@PathVariable Long id){
        return assContractArticleImpl.getAssContractArticleById(id);
    }

    @PostMapping("/add")
    public AssContractArticleResponse createAssContractArticle(@Valid @RequestBody AssContractArticleRequest assContractArticleRequest){
        return assContractArticleImpl.createAssContractArticle(assContractArticleRequest);
    }

    @PutMapping("/update/{id}")
    public AssContractArticleResponse updateAssContractArticle(@Valid @RequestBody AssContractArticleRequest assContractArticleRequest,
                                                             @PathVariable Long id){
        return assContractArticleImpl.updateAssContractArticle(assContractArticleRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAssContractArticle(@PathVariable Long id){
        assContractArticleImpl.deleteAssContractArticle(id);
    }

}


