package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.ExceptionalFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionalFeeRepository extends JpaRepository<ExceptionalFee, Long> {
}
