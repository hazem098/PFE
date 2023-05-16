package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.ProjectReferenceSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectReferenceSequenceRepository extends JpaRepository<ProjectReferenceSequence , Long> {
}
