package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.OfferCandidate;
import lombok.Data;

@Data
public class EvaluationResponse {
    private Long Id ;
    private Integer globalAppreciation;
    private OfferCandidate offerCandidate;
}
