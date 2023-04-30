package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;

import java.util.List;

public interface RecommendationRewardService {
    RecommendationRewardResponse createRecommendationReward(RecommendationRewardRequest request);
    List<RecommendationRewardResponse> getAllRecommendationRewards();
    RecommendationRewardResponse getRecommendationRewardById(Long id);

    RecommendationRewardResponse updateRecommendationReward(RecommendationRewardRequest request, Long id);

    void deleteRecommendationReward(Long id);

}
