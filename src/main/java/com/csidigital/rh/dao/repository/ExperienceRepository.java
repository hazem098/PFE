package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience , Long> {
}
