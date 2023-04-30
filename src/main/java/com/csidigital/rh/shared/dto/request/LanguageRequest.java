package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class LanguageRequest {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private com.csidigital.rh.shared.enumeration.Language language;
    private String additionalInformation;
    private Long technicalFileId ;
}
