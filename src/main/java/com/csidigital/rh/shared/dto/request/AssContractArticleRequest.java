package com.csidigital.rh.shared.dto.request;


import lombok.Data;

@Data
public class AssContractArticleRequest {
    private Long articleId;
    private Long contractId;
    private Integer articleNumber;


    private String description;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}
