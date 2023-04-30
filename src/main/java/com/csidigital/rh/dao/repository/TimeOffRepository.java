package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.TimeOff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeOffRepository extends JpaRepository<TimeOff,Long> {
}
