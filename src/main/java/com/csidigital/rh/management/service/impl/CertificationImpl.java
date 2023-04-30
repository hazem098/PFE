package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Certification;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.dao.repository.CertificationRepository;
import com.csidigital.rh.dao.repository.TechnicalFileRepository;
import com.csidigital.rh.management.service.CertificationService;
import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class CertificationImpl implements CertificationService {
    @Autowired
    private CertificationRepository certificationRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TechnicalFileRepository technicalFileRepository;

    @Override
    public CertificationResponse createCertification(CertificationRequest request) {
        TechnicalFile technicalFile = technicalFileRepository.findById(request.getTechnicalFileId()).orElseThrow();
        Certification certification = modelMapper.map(request, Certification.class);
        certification.setTechnicalFile(technicalFile);
        Certification certificationSaved = certificationRepository.save(certification);
        return modelMapper.map(certificationSaved, CertificationResponse.class);
    }

    @Override
    public List<CertificationResponse> getAllCertifications() {
        List<Certification> certifications = certificationRepository.findAll();
        List<CertificationResponse> certificationResponseList = new ArrayList<>();

        for (Certification certification : certifications) {
            CertificationResponse response = modelMapper.map(certification ,CertificationResponse.class);
            certificationResponseList.add(response);
        }

        return certificationResponseList;
    }

    @Override
    public CertificationResponse getCertificationById(Long id) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification with id " + id + " not found"));
        CertificationResponse certificationResponse = modelMapper.map(certification, CertificationResponse.class);
        return certificationResponse;
    }

    @Override
    public CertificationResponse updateCertification(CertificationRequest request, Long id) {
        TechnicalFile technicalFile = technicalFileRepository.findById(request.getTechnicalFileId())
                .orElseThrow(/*() -> new ResourceNotFoundException("Technical File not found with id " + technicalFileId)*/);
        Certification existingCertification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification with id: " + id + " not found"));
        modelMapper.map(request, existingCertification);
        Certification savedCertification = certificationRepository.save(existingCertification);
        existingCertification.setTechnicalFile(technicalFile);
        return modelMapper.map(savedCertification, CertificationResponse.class);
    }

    @Override
    public void deleteCertification(Long id) {certificationRepository.deleteById(id);
    }


}
