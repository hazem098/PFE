package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.BenefitRC;
import com.csidigital.rh.dao.repository.BenefitRCRepository;
import com.csidigital.rh.management.service.BenefitRCService;
import com.csidigital.rh.shared.dto.request.BenefitRCRequest;
import com.csidigital.rh.shared.dto.response.BenefitRCResponse;
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

public class BenefitRCImpl implements BenefitRCService {
    @Autowired
    private BenefitRCRepository benefitRCRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BenefitRCResponse createBenefitRC(BenefitRCRequest request) {
        BenefitRC benefitRC = modelMapper.map(request, BenefitRC.class);
        BenefitRC BenefitRCSaved = benefitRCRepository.save(benefitRC);
        return modelMapper.map(BenefitRCSaved, BenefitRCResponse.class);
    }

    @Override
    public List<BenefitRCResponse> getAllBenefitRC() {
        List<BenefitRC> benefitRC = benefitRCRepository.findAll();
        List<BenefitRCResponse> benefitRCList = new ArrayList<>();


        for (BenefitRC benefitRC1: benefitRC) {
            BenefitRCResponse response = modelMapper.map(benefitRC1, BenefitRCResponse.class);
            benefitRCList.add(response);
        }

        return benefitRCList;
    }

    @Override
    public BenefitRCResponse getBenefitRCById(Long id) {
        BenefitRC benefitRC = benefitRCRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("BenefitRC with id " +id+ " not found"));
        BenefitRCResponse benefitRCResponse = modelMapper.map(benefitRC, BenefitRCResponse.class);
        return benefitRCResponse;
    }

    @Override
    public BenefitRCResponse updateBenefitRC(BenefitRCRequest request, Long id) {
        BenefitRC existingBenefitRC = benefitRCRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("BenefitRC with id: " + id + " not found"));
        modelMapper.map(request, existingBenefitRC);
        BenefitRC savedBenefitRC = benefitRCRepository.save(existingBenefitRC);
        return modelMapper.map(savedBenefitRC, BenefitRCResponse.class);
    }

    @Override
    public void deleteBenefitRC(Long id) {
        benefitRCRepository.deleteById(id);
    }
}
