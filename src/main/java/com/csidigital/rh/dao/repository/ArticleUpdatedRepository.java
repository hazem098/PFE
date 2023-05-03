package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.ArticleUpdated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleUpdatedRepository extends JpaRepository<ArticleUpdated,Long> {

}
