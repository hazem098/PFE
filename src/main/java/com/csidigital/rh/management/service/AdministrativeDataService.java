package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.AdministrativeDataRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;

import java.util.List;



public interface AdministrativeDataService {


    AdministrativeDataResponse createAdministrativeData(AdministrativeDataRequest request);
    List<AdministrativeDataResponse> getAllAdministrativeData();
    AdministrativeDataResponse getAdministrativeDataById(Long id);

    AdministrativeDataResponse updateAdministrativeData(AdministrativeDataRequest request, Long id);

    void deleteAdministrativeData(Long id);


}
