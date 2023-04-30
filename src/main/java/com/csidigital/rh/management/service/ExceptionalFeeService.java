package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.ExceptionalFeeRequest;
import com.csidigital.rh.shared.dto.response.ExceptionalFeeResponse;

import java.util.List;

public interface ExceptionalFeeService {
    ExceptionalFeeResponse createExceptionalFee(ExceptionalFeeRequest request);
    List<ExceptionalFeeResponse> getAllExceptionalFees();
    ExceptionalFeeResponse getExceptionalFeeById(Long id);

    ExceptionalFeeResponse updateExceptionalFee(ExceptionalFeeRequest request, Long id);

    void deleteExceptionalFee(Long id);
}
