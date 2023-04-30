package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
