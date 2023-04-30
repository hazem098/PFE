package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.RecommendationReward;
import com.csidigital.rh.dao.entity.ResourceContract;
import com.csidigital.rh.dao.repository.RecommendationRewardRepository;
import com.csidigital.rh.dao.repository.ResourceContractRepository;
import com.csidigital.rh.management.service.ResourceContractService;
import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.request.ResourceContractRequest;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
import com.csidigital.rh.shared.dto.response.ResourceContractResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Transactional
@Service
@AllArgsConstructor
public class ResourceContractImpl implements ResourceContractService {
    @Autowired
    private ResourceContractRepository resourceContractRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResourceContractResponse createResourceContract(ResourceContractRequest request) {
        ResourceContract resourceContract= modelMapper.map(request, ResourceContract.class);
        ResourceContract resourceContractSaved = resourceContractRepository.save(resourceContract);
        return modelMapper.map(resourceContractSaved, ResourceContractResponse.class);
    }

    @Override
    public List<ResourceContractResponse> getAllResourceContracts() {
        List<ResourceContract> resourceContracts = resourceContractRepository.findAll();
        List<ResourceContractResponse> resourceContractResponseList = new ArrayList<>();

        for (ResourceContract resourceContract : resourceContracts) {
            ResourceContractResponse response = modelMapper.map(resourceContract ,ResourceContractResponse.class);
            resourceContractResponseList.add(response);
        }

        return resourceContractResponseList;
    }

    @Override
    public ResourceContractResponse getResourceContractById(Long id) {
        ResourceContract resourceContract = resourceContractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResourceContract with id " + id + " not found"));
        ResourceContractResponse resourceContractResponse = modelMapper.map(resourceContract, ResourceContractResponse.class);
        return resourceContractResponse;
    }

    @Override
    public ResourceContractResponse updateResourceContract(ResourceContractRequest request, Long id) {
        ResourceContract existingResourceContract = resourceContractRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ResourceContract with id: " + id + " not found"));
        modelMapper.map(request, existingResourceContract);
        ResourceContract savedResourceContract = resourceContractRepository.save(existingResourceContract);
        return modelMapper.map(savedResourceContract, ResourceContractResponse.class);
    }

    @Override
    public void deleteResourceContract(Long id) {resourceContractRepository.deleteById(id);
    }
}
