package com.csidigital.rh.shared.dto.response;
import com.csidigital.rh.shared.enumeration.LanguageLevel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
@Data
public class LanguageResponse {


    private Long Id;
    private String language;
    private LanguageLevel languageLevel;
    private String additionalInformation;
    private Long technicalFileId ;
}
