package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.BackOffice;
import com.csidigital.rh.management.service.impl.AdministrativeDataImpl;
import com.csidigital.rh.management.service.impl.BackOfficeImpl;
import com.csidigital.rh.shared.dto.request.AdministrativeDataRequest;
import com.csidigital.rh.shared.dto.request.BackOfficeRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;
import com.csidigital.rh.shared.dto.response.BackOfficeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Transactional
@RestController
@RequestMapping("/rh/backoffice")
public class BackOfficeController {
    @Autowired
    private BackOfficeImpl backOffice;

    @GetMapping("/getAll")
    public List<BackOfficeResponse> getAllBackOffice() {
        return backOffice.getAllBackOffice();
    }

    @GetMapping("/get/{id}")
    public BackOfficeResponse getBackOfficeById(@PathVariable Long id){
        return backOffice.getBackOfficeById(id);
    }

    @PostMapping("/addBackOffice")
    public BackOfficeResponse createBackoffice(@Valid @RequestBody BackOfficeRequest backOfficeRequest){
        return backOffice.createBackoffice(backOfficeRequest);
    }

    @PutMapping("/update/{id}")
    public BackOfficeResponse updateBackOffice(@Valid @RequestBody BackOfficeRequest backOfficeRequest,
                                               @PathVariable Long id){
        return backOffice.updateBackOffice(backOfficeRequest, id);
    }

    @DeleteMapping("/deleteAdmin/{id}")
    public void deleteBackOffice(@PathVariable Long id){
        backOffice.deleteBackOffice(id);
    }


}

