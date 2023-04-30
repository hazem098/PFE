package com.csidigital.rh.management.service;


import com.csidigital.rh.shared.dto.request.LanguageRequest;
import com.csidigital.rh.shared.dto.response.LanguageResponse;

import java.util.List;

public interface LanguageService {
    LanguageResponse createLanguage(LanguageRequest request);
    List<LanguageResponse> getAllLanguage();
    LanguageResponse getLanguageById(Long id);

    LanguageResponse updateLanguage(LanguageRequest request, Long id);

    void deleteLanguage(Long id);

}
