package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.CertificationImpl;
import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/certification")
public class CertificationController {
    @Autowired
    private CertificationImpl certification;

    @GetMapping("/getAll")
    public List<CertificationResponse> getAllCertifications(){
        return certification.getAllCertifications();
    }

    @GetMapping("/getCertification/{id}")
    public CertificationResponse getCertificationById(@PathVariable Long id){
        return certification.getCertificationById(id);
    }

    @PostMapping("/addCertification")
    public CertificationResponse createCertification(@Valid @RequestBody CertificationRequest certificationRequest){
        return certification.createCertification(certificationRequest);
    }

    @PutMapping("/updateCertification/{id}")
    public CertificationResponse updateCertification(@Valid @RequestBody CertificationRequest certificationRequest,
                                                     @PathVariable Long id){
        return certification.updateCertification(certificationRequest, id);
    }

    @DeleteMapping("/deleteCertification/{id}")
    public void deleteCertification(@PathVariable Long id){
        certification.deleteCertification(id);
    }
}
