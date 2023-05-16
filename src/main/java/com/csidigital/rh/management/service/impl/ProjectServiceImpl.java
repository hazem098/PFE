package com.csidigital.rh.management.service.impl;




import com.csidigital.rh.dao.entity.ProjectReferenceSequence;
import com.csidigital.rh.dao.repository.ProjectReferenceSequenceRepository;
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
        project = projectRepository.save(project);

        sequence.incrementNextValue();
        sequenceRepository.save(sequence);

        Project ProjectSaved = projectRepository.save(project);
        return modelMapper.map(ProjectSaved, ProjectDtoResponse.class);
    }

    @Override
    public ProjectDtoResponse updateProject(Long id, ProjectDtoRequest projectDtoRequest) {
        Project project = projectRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Project with id: " + id + " not found"));
        modelMapper.map(projectDtoRequest, project);
      Project updatedProject = projectRepository.save(project);
        return modelMapper.map(updatedProject, ProjectDtoResponse.class);
    }

    @Override
    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);

    }
}
