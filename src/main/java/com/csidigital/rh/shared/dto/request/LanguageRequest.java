package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.LanguageLevel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class LanguageRequest {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String language;
    private LanguageLevel languageLevel;
    private String additionalInformation;
    private Long technicalFileId ;
}
