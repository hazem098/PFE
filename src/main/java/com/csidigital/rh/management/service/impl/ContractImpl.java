package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Certification;
import com.csidigital.rh.dao.entity.Contract;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.repository.CertificationRepository;
import com.csidigital.rh.dao.repository.ContractRepository;
import com.csidigital.rh.dao.repository.ResourceRepository;
import com.csidigital.rh.management.service.ContractService;
import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.request.ContractRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import com.csidigital.rh.shared.dto.response.ContractResponse;
import com.csidigital.rh.shared.enumeration.Status;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ContractImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired

    private ResourceRepository resourceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ContractResponse createContract(ContractRequest request) {
       Resource resource = null;
       if (request.getResourceId() != null) {
           resource = resourceRepository.findById(request.getResourceId())
                   .orElseThrow();}

        Contract contract = modelMapper.map(request, Contract.class);

      contract.setResource(resource);
      contract.setContractStatus(Status.STILL_PENDING);
        Contract contractSaved = contractRepository.save(contract);
        return modelMapper.map(contractSaved, ContractResponse.class);
    }


    @Override
    public List<ContractResponse> getAllContracts() {
        List<Contract> contracts = contractRepository.findAll();
        List<ContractResponse> contractResponseList = new ArrayList<>();

        for (Contract contract : contracts) {
            ContractResponse response = modelMapper.map(contract ,ContractResponse.class);
            contractResponseList.add(response);
        }

        return contractResponseList;
    }

    @Override
    public ContractResponse getContractById(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract with id " + id + " not found"));
        ContractResponse contractResponse = modelMapper.map(contract, ContractResponse.class);
        return contractResponse;
    }

    @Override
    public ContractResponse updateContract(ContractRequest request, Long id) {
        Contract existingContract = contractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contract with id: " + id + " not found"));
        modelMapper.map(request, existingContract);
        Contract savedContract = contractRepository.save(existingContract);
        return modelMapper.map(savedContract, ContractResponse.class);
    }

    @Override
    public void deleteContract(Long id) {contractRepository.deleteById(id);
    }

    @Override
    public void updateStatusById(Long id, String contractStatus) {
        contractRepository.updateStatusById(id, contractStatus);
    }

    @Override
    public void updateStatusToAcceptedById(Long id) {
        contractRepository.updateStatusToAcceptedById(id);

    }

    @Override
    public void updateStatusToRefusedById(Long id) {
        contractRepository.updateStatusToRefusedById(id);

    }
}
