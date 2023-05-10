package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.OfferCandidate;
import lombok.Data;

import java.util.List;

@Data
public class EvaluationRequest {
    private Integer globalAppreciation;
    private List<OfferCandidate>offerCandidates;

}
