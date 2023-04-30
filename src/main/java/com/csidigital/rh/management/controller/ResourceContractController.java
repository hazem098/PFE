package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.RecommendationRewardImpl;
import com.csidigital.rh.management.service.impl.ResourceContractImpl;
import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.request.ResourceContractRequest;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
import com.csidigital.rh.shared.dto.response.ResourceContractResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/resourceContract")
public class ResourceContractController {
    @Autowired
    private ResourceContractImpl resourceContract;

    @GetMapping("/getAll")
    public List<ResourceContractResponse> getAllResourceContacts(){
        return resourceContract.getAllResourceContracts();
    }

    @GetMapping("/getResourceContract/{id}")
    public ResourceContractResponse  getResourceContractById(@PathVariable Long id){
        return resourceContract.getResourceContractById(id);
    }

    @PostMapping("/addResourceContract")
    public ResourceContractResponse createResourceContract(@Valid @RequestBody ResourceContractRequest resourceContractRequest){
        return resourceContract.createResourceContract(resourceContractRequest);
    }

    @PutMapping("/updateResourceContract/{id}")
    public ResourceContractResponse updateResourceContract(@Valid @RequestBody ResourceContractRequest resourceContractRequest,
                                                                   @PathVariable Long id){
        return resourceContract.updateResourceContract(resourceContractRequest, id);
    }

    @DeleteMapping("/deleteResourceContract/{id}")
    public void deleteResourceContract(@PathVariable Long id){
        resourceContract.deleteResourceContract(id);
    }
}
