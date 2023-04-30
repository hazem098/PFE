package com.csidigital.rh.management.controller;
import com.csidigital.rh.management.service.impl.QuestionImpl;
import com.csidigital.rh.shared.dto.request.QuestionRequest;
import com.csidigital.rh.shared.dto.response.QuestionResponse;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/Question")
public class QuestionController {
    @Autowired
    private QuestionImpl questionImpl ;

    @GetMapping("getAll")
    public List<QuestionResponse> getAllQuestion() {
        return questionImpl.getAllQuestion();
    }

    @GetMapping("/getBy/{id}")
    public QuestionResponse getQuestionById(@PathVariable Long id){
        return questionImpl.getQuestionById(id);
    }

    @PostMapping("/add")
    public QuestionResponse createQuestion(@Valid @RequestBody QuestionRequest questionRequest){
        return questionImpl.createQuestion(questionRequest);
    }

    @PutMapping("/update/{id}")
    public QuestionResponse updateQuestiony(@Valid @RequestBody QuestionRequest questionRequest,
                                                   @PathVariable Long id){
        return questionImpl.updateQuestion(questionRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(@PathVariable Long id){
        questionImpl.deleteQuestion(id);
    }

}
