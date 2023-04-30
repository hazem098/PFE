package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.RecommendationReward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRewardRepository extends JpaRepository<RecommendationReward,Long> {
}
