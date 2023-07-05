package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Phase;
import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.entity.Task;
import com.csidigital.rh.dao.repository.PhaseRepository;
import com.csidigital.rh.dao.repository.ProjectRepository;
import com.csidigital.rh.shared.dto.request.PhaseRequest;
import com.csidigital.rh.shared.dto.request.TaskDtoRequest;
import com.csidigital.rh.shared.dto.response.PhaseResponse;
import com.csidigital.rh.shared.dto.response.ProjectDtoResponse;
import com.csidigital.rh.shared.dto.response.TaskDtoResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhaseService {
    @Autowired
    private PhaseRepository phaseRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ModelMapper modelMapper ;
    public List<Phase> getAllPhases() {
        List<Phase> phases = phaseRepository.findAll();
        List<PhaseResponse> phaseList = new ArrayList<>();



        return phases;
    }
    public PhaseResponse getPhaseById(Long id) {
        Phase phase = phaseRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("phase with id " +id+ " not found"));
        PhaseResponse phaseResponse = modelMapper.map(phase, PhaseResponse.class);

        return phaseResponse;
    }
    public Phase createPhase(PhaseRequest request , Long projectId) {



       Project project = projectRepository.findById(projectId).orElse(null);
        Phase phase = modelMapper.map(request, Phase.class);

        project.getPhases().add(phase);

        phase.setProject(project);


        Phase phaseSaved = phaseRepository.save(phase);


        return phaseSaved;
    }
    public List<Phase> createPhases(List<PhaseRequest> requests, Long projectId) {
        List<Phase> phases = new ArrayList<>();

        Project project = projectRepository.findById(projectId).orElse(null);
        if (project == null) {
            // Handle the case where the project with the given projectId doesn't exist
            return phases;
        }

        for (PhaseRequest request : requests) {
            Phase phase = modelMapper.map(request, Phase.class);
            phase.setProject(project);

            Phase phaseSaved = phaseRepository.save(phase);
            phases.add(phaseSaved);
        }

        return phases;
    }

}
