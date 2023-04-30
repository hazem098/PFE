package com.csidigital.rh.management.controller;


import com.csidigital.rh.management.service.impl.LanguageImpl;
import com.csidigital.rh.shared.dto.request.LanguageRequest;
import com.csidigital.rh.shared.dto.response.LanguageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("rh/Language")
public class LanguageController {

    @Autowired
    private LanguageImpl languageImpl ;

    @GetMapping("getAll")
    public List<LanguageResponse> getAllLanguage() {
        return languageImpl.getAllLanguage();
    }

    @GetMapping("/getBy/{id}")
    public LanguageResponse getLanguageById(@PathVariable Long id){
        return languageImpl.getLanguageById(id);
    }

    @PostMapping("/add")
    public LanguageResponse createLanguage(@Valid @RequestBody LanguageRequest languageRequest){
        return languageImpl.createLanguage(languageRequest);
    }

    @PutMapping("/update/{id}")
    public LanguageResponse updateLanguage(@Valid @RequestBody LanguageRequest languageRequest,
                                                   @PathVariable Long id){
        return languageImpl.updateLanguage(languageRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLanguage(@PathVariable Long id){
        languageImpl.deleteLanguage(id);
    }

}
