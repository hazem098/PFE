package com.csidigital.rh.management.service.impl;


import com.csidigital.rh.dao.entity.Interview;
import com.csidigital.rh.dao.repository.InterviewRepository;
import com.csidigital.rh.management.service.InterviewService;
import com.csidigital.rh.shared.dto.request.InterviewRequest;
import com.csidigital.rh.shared.dto.response.InterviewResponse;
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

public class InterviewImpl implements InterviewService {
    @Autowired
    private InterviewRepository interviewRepository ;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InterviewResponse createInterview(InterviewRequest request) {
        Interview interview = modelMapper.map(request, Interview.class);
        Interview InterviewSaved = interviewRepository.save(interview);
        return modelMapper.map(InterviewSaved, InterviewResponse.class);
    }

    @Override
    public List<InterviewResponse> getAllInterview() {
        List<Interview> interview = interviewRepository.findAll();
        List<InterviewResponse> interviewList = new ArrayList<>();


        for (Interview interviews: interview) {
            InterviewResponse response = modelMapper.map(interviews, InterviewResponse.class);
            interviewList.add(response);
        }

        return interviewList;
    }

    @Override
    public InterviewResponse getInterviewById(Long id) {
        Interview interview =interviewRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Interview with id " +id+ " not found"));
        InterviewResponse interviewResponse = modelMapper.map(interview, InterviewResponse.class);
        return interviewResponse;
    }

    @Override
    public InterviewResponse updateInterview(InterviewRequest request, Long id) {
        Interview existingInterview = interviewRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Interview with id: " + id + " not found"));
        modelMapper.map(request, existingInterview);
        Interview savedInterview = interviewRepository.save(existingInterview);
        return modelMapper.map(savedInterview, InterviewResponse.class);
    }

    @Override
    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }

}
