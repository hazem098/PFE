package com.csidigital.rh.management.service;
import com.csidigital.rh.shared.dto.request.ProjectContractRequest;
import com.csidigital.rh.shared.dto.response.ProjectContractResponse;

import java.util.List;

public interface ProjectContractService  {
    ProjectContractResponse createProjectContract(ProjectContractRequest request);
    List<ProjectContractResponse> getAllProjectContract();
    ProjectContractResponse getProjectContractById(Long id);

    ProjectContractResponse updateProjectContract(ProjectContractRequest request, Long id);

    void deleteProjectContract(Long id);

}
