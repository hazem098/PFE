package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.Provenance;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
public class CandidateResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Set<Long> offer;
}
