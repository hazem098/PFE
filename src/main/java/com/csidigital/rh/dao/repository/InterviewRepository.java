package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Interview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview, Long> {
}
