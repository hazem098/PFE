package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.ArticleUpdatedImpl;
import com.csidigital.rh.shared.dto.request.ArUpdatedRequest;
import com.csidigital.rh.shared.dto.response.ArticleUpdatedResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/articleUpdated")
public class ArticleUpdatedController {

    @Autowired
    private ArticleUpdatedImpl articleUpdated;
    @GetMapping("/getAll")
    public List<ArticleUpdatedResponse> getAllArticlesUpdated() {
        return articleUpdated.getAllArticlesUpdated();
    }

    @GetMapping("/get/{id}")
    public ArticleUpdatedResponse getArticleUpdatedById(@PathVariable Long id){
        return articleUpdated.getArticleUpdatedById(id);
    }

    @PostMapping("/add")
    public ArticleUpdatedResponse  createArticleUpdated(@Valid @RequestBody ArUpdatedRequest arUpdatedRequest){
        return articleUpdated.createArticleUpdated(arUpdatedRequest);
    }

    @PutMapping("/update/{id}")
    public ArticleUpdatedResponse UpdateArticleUpdatedResponse(@Valid @RequestBody ArUpdatedRequest arUpdatedRequest,
                                                        @PathVariable Long id){
        return articleUpdated.UpdateArticleUpdatedResponse(arUpdatedRequest,id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteArticleUpdated(@PathVariable Long id){

        articleUpdated.deleteArticleUpdated(id);
    }


}
