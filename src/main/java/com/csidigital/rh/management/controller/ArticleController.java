package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.ArticleImpl;

import com.csidigital.rh.shared.dto.request.ArticleRequest;
import com.csidigital.rh.shared.dto.response.ArticleResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/article")


public class ArticleController {

    @Autowired
    private ArticleImpl articleService ;

    @GetMapping("/getArticles")
    public List<ArticleResponse> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/get/{id}")
    public ArticleResponse getArticleById(@PathVariable Long id){
        return articleService.getArticleById(id);
    }

    @PostMapping("/add")
    public ArticleResponse createArticle(@Valid @RequestBody ArticleRequest articleRequest){
        return articleService.createArticle(articleRequest);
    }

    @PutMapping("/update/{id}")
    public ArticleResponse updateArticle(@Valid @RequestBody ArticleRequest ArticleRequest,
                                                 @PathVariable Long id){
        return articleService.updateArticle(ArticleRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticle(@PathVariable Long id){
        articleService.deleteArticle(id);
    }


    @GetMapping("/description")
    public void getArticleDescription(@PathVariable String articleTitle)
    {
        articleService.getArticleDescription(articleTitle);
    }

}
