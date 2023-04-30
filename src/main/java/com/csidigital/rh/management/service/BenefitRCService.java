package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.BenefitRCRequest;
import com.csidigital.rh.shared.dto.response.BenefitRCResponse;

import java.util.List;

public interface BenefitRCService {
    BenefitRCResponse createBenefitRC(BenefitRCRequest request);
    List<BenefitRCResponse> getAllBenefitRC();
    BenefitRCResponse getBenefitRCById(Long id);

    BenefitRCResponse updateBenefitRC(BenefitRCRequest request, Long id);

    void deleteBenefitRC(Long id);

}
