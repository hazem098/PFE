package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.RecommendationRewardImpl;
import com.csidigital.rh.management.service.impl.ResourceImpl;
import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.request.ResourceRequest;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
import com.csidigital.rh.shared.dto.response.ResourceResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Transactional
@RequestMapping("/rh/resource")
public class ResourceController {
    @Autowired
    private ResourceImpl resource;

    @GetMapping("/getAll")
    public List<ResourceResponse> getAllResources(){
        return resource.getAllResources();
    }

    @GetMapping("/getResource/{id}")
    public ResourceResponse  getResourceById(@PathVariable Long id){
        return resource.getResourceById(id);
    }

    @PostMapping("/addResource")
    public ResourceResponse createResource(@Valid @RequestBody ResourceRequest resourceRequest){
        return resource.createResource(resourceRequest);
    }

    @PutMapping("/updateResource/{id}")
    public ResourceResponse updateResource(@Valid @RequestBody ResourceRequest resourceRequest,
                                                                   @PathVariable Long id){
        return resource.updateResource(resourceRequest, id);
    }

    @DeleteMapping("/deleteResource/{id}")
    public void deleteResource(@PathVariable Long id){
        resource.deleteResource(id);
    }
}
