package com.csidigital.rh.management.service;
import com.csidigital.rh.shared.dto.request.OfferRequest;
import com.csidigital.rh.shared.dto.response.OfferResponse;

import java.util.List;

public interface OfferService {
    OfferResponse createOffer(OfferRequest request);
    List<OfferResponse> getAllOffer();
    OfferResponse getOfferById(Long id);

    OfferResponse updateOffer(OfferRequest request, Long id);

    void deleteOffer(Long id);

}

