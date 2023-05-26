package com.csidigital.rh.management.service.impl;




import com.csidigital.rh.dao.entity.ProjectReferenceSequence;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.repository.ProjectReferenceSequenceRepository;
import com.csidigital.rh.dao.repository.ResourceRepository;
import com.csidigital.rh.management.service.ProjectService;



import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.repository.ProjectRepository;
import com.csidigital.rh.shared.dto.request.ProjectDtoRequest;
import com.csidigital.rh.shared.dto.response.ProjectDtoResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private  ProjectRepository projectRepository;
    @Autowired
    private ResourceRepository resourceRepository ;
    @Autowired
    private ProjectReferenceSequenceRepository sequenceRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectReferenceSequenceRepository sequenceRepository) {
        this.projectRepository = projectRepository;
        this.sequenceRepository = sequenceRepository;}
    @Override
    public List<ProjectDtoResponse> getAllProjects() {

        List<Project> projects = projectRepository.findAll();
        List<ProjectDtoResponse> projectList = new ArrayList<>();

        for (Project project : projects) {
            ProjectDtoResponse projectDtoResponse = modelMapper.map(project, ProjectDtoResponse.class);
            projectList.add(projectDtoResponse);
        }

        return projectList;
    }

    @Override
    public ProjectDtoResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project with id " +id+ " not found"));
        ProjectDtoResponse projectDtoResponse = modelMapper.map(project, ProjectDtoResponse.class);
        return projectDtoResponse;

    }

    @Override
    public List<Resource> getProjectResource(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project with id " +id+ " not found"));

        return project.getResources();

    }
    @Override
    public ProjectDtoResponse createProject(ProjectDtoRequest projectDtoRequest) {

        ProjectReferenceSequence sequence = sequenceRepository.findById(1L)
                .orElse(null) ;
        if (sequence == null) {
            sequence = new ProjectReferenceSequence();
            sequence = sequenceRepository.save(sequence);
        }
        Project project = modelMapper.map(projectDtoRequest, Project.class);
        String projectReference = String.format("PR_%04d", sequence.getNextValue());
        project.setProjectReference(projectReference);

        List<Resource> existingResources = resourceRepository.findAllById(projectDtoRequest.getResourceIds());
        for(Resource res : existingResources) {
            res.setProject(project);
            //resourceRepository.save(res);
        }
     Resource responsable = resourceRepository.findById(projectDtoRequest.getResponsableNum()).orElseThrow();

        project.setResources(existingResources);
        project.setResponsable(responsable);
        project = projectRepository.save(project);

        responsable.setProject(project);
       resourceRepository.save(responsable);
        resourceRepository.saveAll(existingResources);


        sequence.incrementNextValue();
        sequenceRepository.save(sequence);
        Project ProjectSaved = projectRepository.save(project);
        return modelMapper.map(ProjectSaved, ProjectDtoResponse.class);
    }

    public void addResourceToProject(Long projectId, List<Long> resourceIds) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
        List<Resource> resources = resourceRepository.findAllById(resourceIds);
        for(Resource res : resources){
            res.setProject(project);
            project.getResources().add(res);
        }
        // Add the resource to the project's resource list


        // Save the updated project
        projectRepository.save(project);
    }

    @Override
    public ProjectDtoResponse updateProject(Long id, ProjectDtoRequest projectDtoRequest) {
        Resource responsable =null;
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project with id: " + id + " not found"));

        modelMapper.map(projectDtoRequest, project);

        List<Resource> existingResources = new ArrayList<>();

        for (Long resourceId : projectDtoRequest.getResourceIds()) {
            Resource resource = resourceRepository.findById(resourceId)
                    .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + resourceId + " not found"));
            existingResources.add(resource);
        }
    if (resourceRepository.findById(projectDtoRequest.getResponsableNum())!=null) {
        responsable = resourceRepository.findById(projectDtoRequest.getResponsableNum())
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + projectDtoRequest.getResponsableNum() + " not found"));
        if (responsable.getId() == null) {
            responsable = resourceRepository.save(responsable);
        }
    }
        // Save new resources if necessary
        for (Resource resource : existingResources) {
            if (resource.getId() == null) {
                resource = resourceRepository.save(resource);
            }
            resource.setProject(project);
        }

        // Save responsible resource if necessary

        responsable.setProject(project);
        resourceRepository.save(responsable);
        project.setResources(existingResources);
        project.setResponsable(responsable);

        Project updatedProject = projectRepository.save(project);
        return modelMapper.map(updatedProject, ProjectDtoResponse.class);
    }

    /*public ProjectDtoResponse updateProject(Long id, ProjectDtoRequest projectDtoRequest) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project with id: " + id + " not found"));
        modelMapper.map(projectDtoRequest, project);
        List<Resource> existingResources = resourceRepository.findAllById(projectDtoRequest.getResourceIds());

        for(Resource res : existingResources) {
            res.setProject(project);
        }
        Resource responsable = resourceRepository.findById(projectDtoRequest.getResponsableNum()).orElseThrow();
        responsable.setProject(project);
        Resource resp= resourceRepository.save(responsable);
        project.setResources(existingResources);
        project.setResponsable(resp);

        Project updatedProject = projectRepository.save(project);
        return modelMapper.map(updatedProject, ProjectDtoResponse.class);
    }*/

    @Override
    public void deleteProjectById(Long id) {
        Project project = projectRepository.findById(id).orElse(null);



            projectRepository.deleteById(id);

    }
}



