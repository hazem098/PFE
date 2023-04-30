package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.dao.repository.AdministrativeDataRepository;
import com.csidigital.rh.dao.repository.AssQuestionInterviewRepository;
import com.csidigital.rh.dao.repository.InterviewRepository;
import com.csidigital.rh.dao.repository.QuestionRepository;
import com.csidigital.rh.management.service.AdministrativeDataService;
import com.csidigital.rh.management.service.AssQuestionInterviewService;
import com.csidigital.rh.shared.dto.request.AdministrativeDataRequest;
import com.csidigital.rh.shared.dto.request.AssQuestionInterviewRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;
import com.csidigital.rh.shared.dto.response.AssQuestionInterviewResponse;
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
public class AssQuestionInterviewImpl implements AssQuestionInterviewService {
    @Autowired
    private AssQuestionInterviewRepository assQuestionInterviewRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private InterviewRepository interviewRepository;

    @Override
    public AssQuestionInterviewResponse createAssQuestionInterview(AssQuestionInterviewRequest request) {
        Question question = questionRepository.findById(request.getQuestionNum()).orElseThrow();
        Interview interview = interviewRepository.findById(request.getInterviewNum()).orElseThrow();
        AssQuestionInterview assQuestionInterview = modelMapper.map(request, AssQuestionInterview.class);
        assQuestionInterview.setQuestion(question);
        assQuestionInterview.setInterview(interview);
        AssQuestionInterview assQuestionInterviewSaved = assQuestionInterviewRepository.save(assQuestionInterview);
        return modelMapper.map(assQuestionInterviewSaved, AssQuestionInterviewResponse.class);
    }

    @Override
    public List<AssQuestionInterviewResponse> getAllAssQuestionInterview() {
        List<AssQuestionInterview> assQuestionInterviews = assQuestionInterviewRepository.findAll();
        List<AssQuestionInterviewResponse> assQuestionInterviewList = new ArrayList<>();

        for (AssQuestionInterview assQuestionInterview : assQuestionInterviews) {
            AssQuestionInterviewResponse response = modelMapper.map(assQuestionInterview, AssQuestionInterviewResponse.class);
            assQuestionInterviewList.add(response);
        }

        return assQuestionInterviewList;
    }

    @Override
    public AssQuestionInterviewResponse getAssQuestionInterviewDataById(Long id) {
        AssQuestionInterview assQuestionInterview =assQuestionInterviewRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("AssQuestionInterview with id " +id+ " not found"));
        AssQuestionInterviewResponse assQuestionInterviewResponse = modelMapper.map(assQuestionInterview, AssQuestionInterviewResponse.class);
        return assQuestionInterviewResponse;
    }

    @Override
    public AssQuestionInterviewResponse updateAssQuestionInterview(AssQuestionInterviewRequest request, Long id) {
       AssQuestionInterview existingAssQuestionInterview = assQuestionInterviewRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("AssQuestionInterviewData with id: " + id + " not found"));
        modelMapper.map(request, existingAssQuestionInterview);
        AssQuestionInterview savedAssQuestionInterviewData = assQuestionInterviewRepository.save(existingAssQuestionInterview);
        return modelMapper.map(savedAssQuestionInterviewData, AssQuestionInterviewResponse.class);
    }

    @Override
    public void deleteAssQuestionInterviewData(Long id) {
        assQuestionInterviewRepository.deleteById(id);
    }

}
