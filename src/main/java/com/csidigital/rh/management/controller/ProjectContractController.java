package com.csidigital.rh.management.controller;


import com.csidigital.rh.management.service.impl.ProjectContractImpl;
import com.csidigital.rh.shared.dto.request.ProjectContractRequest;
import com.csidigital.rh.shared.dto.response.ProjectContractResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rh/ProjectContract")
public class ProjectContractController {
    @Autowired
    private ProjectContractImpl projectContractImpl ;

    @GetMapping("getAll")
    public List<ProjectContractResponse> getAllProjectContract() {
        return projectContractImpl.getAllProjectContract();
    }

    @GetMapping("/getBy/{id}")
    public ProjectContractResponse getProjectContractById(@PathVariable Long id){
        return projectContractImpl.getProjectContractById(id);
    }

    @PostMapping("/add")
    public ProjectContractResponse createProjectContract(@Valid @RequestBody ProjectContractRequest projectContractRequest){
        return projectContractImpl.createProjectContract(projectContractRequest);
    }

    @PutMapping("/update/{id}")
    public ProjectContractResponse updateProjectContract(@Valid @RequestBody ProjectContractRequest projectContractRequest,
                                                   @PathVariable Long id){
        return projectContractImpl.updateProjectContract(projectContractRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjectContract(@PathVariable Long id){ projectContractImpl.deleteProjectContract(id);
    }

}
