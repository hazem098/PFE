package com.csidigital.rh.management.controller;


import com.csidigital.rh.management.service.impl.ExternalResourceImpl;
import com.csidigital.rh.shared.dto.request.ExternalResourceRequest;
import com.csidigital.rh.shared.dto.response.ExternalResourceResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/ExternalResource")
@CrossOrigin(origins = "*")
public class ExternalResourceController {
    @Autowired
    private ExternalResourceImpl externalResourceImpl ;

    @GetMapping("getAll")
    public List<ExternalResourceResponse> getAllExternalResource() {
        return externalResourceImpl.getAllExternalResource();
    }

    @GetMapping("/getBy/{id}")
    public ExternalResourceResponse getExternalResourceById(@PathVariable Long id){
        return externalResourceImpl.getExternalResourceById(id);
    }

    @PostMapping("/add")
    public ExternalResourceResponse createExternalResource(@Valid @RequestBody ExternalResourceRequest externalResourceRequest){
        return externalResourceImpl.createExternalResource(externalResourceRequest);
    }

    @PutMapping("/update/{id}")
    public ExternalResourceResponse updateExternalResource(@Valid @RequestBody ExternalResourceRequest externalResourceRequest,
                                                   @PathVariable Long id){
        return externalResourceImpl.updateExternalResource(externalResourceRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExternalResource(@PathVariable Long id){
        externalResourceImpl.deleteExternalResource(id);
    }

}
