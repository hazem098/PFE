package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    @Modifying
    @Query(value = "SELECT description FROM article  WHERE article_title =:articleTitle", nativeQuery = true)
    void getArticleDescription(@Param("articleTitle") String articleTitle);

}
