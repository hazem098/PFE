package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.OfferCandidate;
import lombok.Data;

@Data
public class EvaluationRequest {
    private Integer globalAppreciation;
    private Long offerCandidateId;
}
