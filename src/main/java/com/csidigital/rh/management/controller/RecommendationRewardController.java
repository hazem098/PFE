package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.CertificationImpl;
import com.csidigital.rh.management.service.impl.RecommendationRewardImpl;
import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/RecommendationReward")
public class RecommendationRewardController {
    @Autowired
    private RecommendationRewardImpl recommendationReward;

    @GetMapping("/getAll")
    public List<RecommendationRewardResponse> getAllRecommendationRewards(){
        return recommendationReward.getAllRecommendationRewards();
    }

    @GetMapping("/getRecommendationReward/{id}")
    public RecommendationRewardResponse  getRecommendationRewardById(@PathVariable Long id){
        return recommendationReward.getRecommendationRewardById(id);
    }

    @PostMapping("/addRecommendationReward")
    public RecommendationRewardResponse createRecommendationReward(@Valid @RequestBody RecommendationRewardRequest recommendationRewardRequest){
        return recommendationReward.createRecommendationReward(recommendationRewardRequest);
    }

    @PutMapping("/updateRecommendationReward/{id}")
    public RecommendationRewardResponse updateRecommendationReward(@Valid @RequestBody RecommendationRewardRequest recommendationRewardRequest,
                                                     @PathVariable Long id){
        return recommendationReward.updateRecommendationReward(recommendationRewardRequest, id);
    }

    @DeleteMapping("/deleteRecommendationReward/{id}")
    public void deleteCRecommendationReward(@PathVariable Long id){
        recommendationReward.deleteRecommendationReward(id);
    }
}
