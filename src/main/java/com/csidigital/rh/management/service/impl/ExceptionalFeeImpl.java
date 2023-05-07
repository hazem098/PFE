package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.BenefitRC;
import com.csidigital.rh.dao.entity.Contract;
import com.csidigital.rh.dao.entity.ExceptionalFee;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.repository.ContractRepository;
import com.csidigital.rh.dao.repository.ExceptionalFeeRepository;
import com.csidigital.rh.management.service.ExceptionalFeeService;
import com.csidigital.rh.shared.dto.request.ExceptionalFeeRequest;
import com.csidigital.rh.shared.dto.response.ExceptionalFeeResponse;
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
public class ExceptionalFeeImpl implements ExceptionalFeeService {
    @Autowired 
    private ExceptionalFeeRepository exceptionalFeeRepository ;

    @Autowired
    private ContractRepository contractRepository;
    @Autowired 
    private ModelMapper modelMapper ;

    @Override
    public ExceptionalFeeResponse createExceptionalFee(ExceptionalFeeRequest request) {
        Contract contract = null;
        if (request.getContractId() != null) {
            contract = contractRepository.findById(request.getContractId())
                    .orElseThrow();}

        ExceptionalFee exceptionalFee = modelMapper.map(request, ExceptionalFee.class);

        exceptionalFee.setContract(contract);

        ExceptionalFee exceptionalFeeSaved = exceptionalFeeRepository.save(exceptionalFee);
        return modelMapper.map(exceptionalFeeSaved, ExceptionalFeeResponse.class);
    }

    @Override
    public List<ExceptionalFeeResponse> getAllExceptionalFees() {
        List<ExceptionalFee> exceptionalFees = exceptionalFeeRepository.findAll();
        List<ExceptionalFeeResponse> exceptionalFeeList = new ArrayList<>();

        for (ExceptionalFee exceptionalFee : exceptionalFees) {
            ExceptionalFeeResponse response = modelMapper.map(exceptionalFee, ExceptionalFeeResponse.class);
            exceptionalFeeList.add(response);
        }

        return exceptionalFeeList;
    }

    @Override
    public ExceptionalFeeResponse getExceptionalFeeById(Long id) {
        ExceptionalFee exceptionalFee = exceptionalFeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExceptionalFee with id " +id+ " not found"));
        ExceptionalFeeResponse exceptionalFeeResponse = modelMapper.map(exceptionalFee, ExceptionalFeeResponse.class);
        return exceptionalFeeResponse;
    }

    @Override
    public ExceptionalFeeResponse updateExceptionalFee(ExceptionalFeeRequest request, Long id) {
        ExceptionalFee existingExceptionalFee = exceptionalFeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExceptionalFee with id: " + id + " not found"));
        modelMapper.map(request, existingExceptionalFee);
        ExceptionalFee savedExceptionalFee = exceptionalFeeRepository.save(existingExceptionalFee);
        return modelMapper.map(savedExceptionalFee, ExceptionalFeeResponse.class);
    }

    @Override
    public void deleteExceptionalFee(Long id) {
        exceptionalFeeRepository.deleteById(id);
    }


}
