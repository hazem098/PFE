package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.AdministrativeDataService;
import com.csidigital.rh.management.service.impl.AdministrativeDataImpl;
import com.csidigital.rh.shared.dto.request.AdministrativeDataRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;
@Transactional
@RestController
@RequestMapping("/rh/administrativeData")
public class AdministrativeDataController {
    @Autowired
    private AdministrativeDataImpl administrativeData;

    @GetMapping("/getAll")
    public List<AdministrativeDataResponse> getAllAdministrativeData() {
        return administrativeData.getAllAdministrativeData();
    }

    @GetMapping("/get/{id}")
    public AdministrativeDataResponse getAdministrativeDataById(@PathVariable Long id){
        return administrativeData.getAdministrativeDataById(id);
    }

    @PostMapping("/addAdmin")
    public AdministrativeDataResponse createAdministrativeData(@Valid @RequestBody AdministrativeDataRequest administrativeDataRequest){
        return administrativeData.createAdministrativeData(administrativeDataRequest);
    }

    @PutMapping("/update/{id}")
    public AdministrativeDataResponse updateRequirement(@Valid @RequestBody AdministrativeDataRequest administrativeDataRequest,
                                                 @PathVariable Long id){
        return administrativeData.updateAdministrativeData(administrativeDataRequest, id);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteAdministrativeData(@PathVariable Long id){
        administrativeData.deleteAdministrativeData(id);
    }


}
