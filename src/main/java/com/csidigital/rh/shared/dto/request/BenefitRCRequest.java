package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.ContractBenifitType;
import lombok.Data;

@Data

public class BenefitRCRequest {
    private String shortDescription;
    private String description;
    private ContractBenifitType contractBenifitType;
}

