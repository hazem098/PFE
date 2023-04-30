package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.ContractBenifitType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class BenefitRCResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shortDescription;
    private String description;
    private ContractBenifitType contractBenifitType;
}

