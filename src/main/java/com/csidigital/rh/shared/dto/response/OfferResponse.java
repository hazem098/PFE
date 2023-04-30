package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.OfferStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class OfferResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String title;
    private String reference;
    private Date startDate;
    private Date endDate;
    private Date closingDate;
    private Integer candidateNumber;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
    private Set<Long> candidate;

}
