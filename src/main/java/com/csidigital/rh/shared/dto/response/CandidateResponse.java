package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.Provenance;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class CandidateResponse  {
    private Long id;
    private Provenance provenance;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeeSerialNumber;
    private Long AssOfferCandidateId;




}