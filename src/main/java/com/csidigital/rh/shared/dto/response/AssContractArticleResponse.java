package com.csidigital.rh.shared.dto.response;


import jakarta.persistence.Column;
import lombok.Data;

@Data
public class AssContractArticleResponse {
    private Long id;
    private Long articleId;
    private Long contractId;

    private Integer articleNumber;


    private String description;
}
