package com.csidigital.rh.dao.entity;


import com.csidigital.rh.shared.enumeration.OfferStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Offer {
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
    @OneToMany(mappedBy = "offer")
    private List<OfferCandidate> offerCandidateList;


}
