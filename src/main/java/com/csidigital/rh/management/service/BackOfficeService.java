package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.AdministrativeDataRequest;
import com.csidigital.rh.shared.dto.request.BackOfficeRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;
import com.csidigital.rh.shared.dto.response.BackOfficeResponse;

import java.util.List;

public interface BackOfficeService {
    BackOfficeResponse createBackoffice(BackOfficeRequest request);
    List<BackOfficeResponse> getAllBackOffice();
    BackOfficeResponse getBackOfficeById(Long id);

    BackOfficeResponse updateBackOffice(BackOfficeRequest request, Long id);

    void deleteBackOffice(Long id);

}


