package com.csidigital.rh.shared.dto.request;


import lombok.Data;

@Data
public class ArUpdatedRequest {

    private Integer articleNumber;
    private String articleTitle;
    private String description;
    private Long contractId;
}
