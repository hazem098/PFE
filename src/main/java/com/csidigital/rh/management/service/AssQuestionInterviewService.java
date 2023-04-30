package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.AdministrativeDataRequest;
import com.csidigital.rh.shared.dto.request.AssQuestionInterviewRequest;
import com.csidigital.rh.shared.dto.response.AdministrativeDataResponse;
import com.csidigital.rh.shared.dto.response.AssQuestionInterviewResponse;

import java.util.List;

public interface AssQuestionInterviewService {
    AssQuestionInterviewResponse createAssQuestionInterview(AssQuestionInterviewRequest request);
    List<AssQuestionInterviewResponse> getAllAssQuestionInterview();
    AssQuestionInterviewResponse getAssQuestionInterviewDataById(Long id);

    AssQuestionInterviewResponse updateAssQuestionInterview(AssQuestionInterviewRequest request, Long id);

    void deleteAssQuestionInterviewData(Long id);

}
