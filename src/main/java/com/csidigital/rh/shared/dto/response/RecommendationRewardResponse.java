package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.RewardType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class RecommendationRewardResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private double amount;

    private RewardType rewardType;
}
