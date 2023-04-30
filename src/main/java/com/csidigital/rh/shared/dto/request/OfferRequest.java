package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.OfferStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class OfferRequest {
    private String title;
    private String reference;
    private Long AssOfferCandidateId;
    private Date startDate;
    private Date endDate;
    private Date closingDate;
    private Integer candidateNumber;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
}
