package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Contract;
import com.csidigital.rh.dao.entity.RecommendationReward;
import com.csidigital.rh.dao.repository.ContractRepository;
import com.csidigital.rh.dao.repository.RecommendationRewardRepository;
import com.csidigital.rh.management.service.RecommendationRewardService;
import com.csidigital.rh.shared.dto.request.ContractRequest;
import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.response.ContractResponse;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
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
public class RecommendationRewardImpl implements RecommendationRewardService {
    @Autowired
    private RecommendationRewardRepository recommendationRewardRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RecommendationRewardResponse createRecommendationReward(RecommendationRewardRequest request) {
        RecommendationReward recommendationReward = modelMapper.map(request, RecommendationReward.class);
        RecommendationReward recommendationRewardSaved = recommendationRewardRepository.save(recommendationReward);
        return modelMapper.map(recommendationRewardSaved, RecommendationRewardResponse.class);
    }

    @Override
    public List<RecommendationRewardResponse> getAllRecommendationRewards() {
        List<RecommendationReward> recommendationRewards = recommendationRewardRepository.findAll();
        List<RecommendationRewardResponse> recommendationRewardResponseList = new ArrayList<>();

        for (RecommendationReward recommendationReward : recommendationRewards) {
            RecommendationRewardResponse response = modelMapper.map(recommendationReward ,RecommendationRewardResponse.class);
            recommendationRewardResponseList.add(response);
        }

        return recommendationRewardResponseList;
    }

    @Override
    public RecommendationRewardResponse getRecommendationRewardById(Long id) {
        RecommendationReward recommendationReward = recommendationRewardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecommendationReward with id " + id + " not found"));
        RecommendationRewardResponse recommendationRewardResponse = modelMapper.map(recommendationReward, RecommendationRewardResponse.class);
        return recommendationRewardResponse;
    }

    @Override
    public RecommendationRewardResponse updateRecommendationReward(RecommendationRewardRequest request, Long id) {
        RecommendationReward existingRecommendationReward = recommendationRewardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("RecommendationReward with id: " + id + " not found"));
        modelMapper.map(request, existingRecommendationReward);
        RecommendationReward savedRecommendationReward = recommendationRewardRepository.save(existingRecommendationReward);
        return modelMapper.map(savedRecommendationReward, RecommendationRewardResponse.class);
    }

    @Override
    public void deleteRecommendationReward(Long id) {recommendationRewardRepository.deleteById(id);
    }
}
