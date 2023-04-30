package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.BenefitRC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefitRCRepository extends JpaRepository<BenefitRC, Long> {
}
