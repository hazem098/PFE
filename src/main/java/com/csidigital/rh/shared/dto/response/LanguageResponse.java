package com.csidigital.rh.shared.dto.response;
import lombok.Data;
@Data
public class LanguageResponse {

    private com.csidigital.rh.shared.enumeration.Language language;
    private String additionalInformation;
}
