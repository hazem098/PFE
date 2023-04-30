package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.SkillsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsCategoryRepository extends JpaRepository<SkillsCategory,Long> {
}
