package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.ProjectContract;
import com.csidigital.rh.dao.repository.ProjectContractRepository;
import com.csidigital.rh.management.service.ProjectContractService;
import com.csidigital.rh.shared.dto.request.ProjectContractRequest;
import com.csidigital.rh.shared.dto.response.ProjectContractResponse;
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



public class ProjectContractImpl implements ProjectContractService {

    @Autowired
    private ProjectContractRepository projectContractRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectContractResponse createProjectContract(ProjectContractRequest request) {
        ProjectContract projectContract = modelMapper.map(request, ProjectContract.class);
        ProjectContract ProjectContractSaved = projectContractRepository.save(projectContract);
        return modelMapper.map(ProjectContractSaved, ProjectContractResponse.class);
    }

    @Override
    public List<ProjectContractResponse> getAllProjectContract() {
        List<ProjectContract> projectContract = projectContractRepository.findAll();
        List<ProjectContractResponse> projectContractList = new ArrayList<>();


        for (ProjectContract projectContracts: projectContract) {
            ProjectContractResponse response = modelMapper.map(projectContracts, ProjectContractResponse.class);
            projectContractList.add(response);
        }

        return projectContractList;
    }

    @Override
    public ProjectContractResponse getProjectContractById(Long id) {
        ProjectContract projectContract = projectContractRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ProjectContract with id " +id+ " not found"));
        ProjectContractResponse projectContractResponse = modelMapper.map(projectContract, ProjectContractResponse.class);
        return projectContractResponse;
    }

    @Override
    public ProjectContractResponse updateProjectContract(ProjectContractRequest request, Long id) {
        ProjectContract existingProjectContract = projectContractRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ProjectContract with id: " + id + " not found"));
        modelMapper.map(request, existingProjectContract);
        ProjectContract savedProjectContract = projectContractRepository.save(existingProjectContract);
        return modelMapper.map(savedProjectContract, ProjectContractResponse.class);
    }

    @Override
    public void deleteProjectContract(Long id) {
        projectContractRepository.deleteById(id);
    }

}
