package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.InterviewType;
import lombok.Data;

@Data
public class QuestionRequest {
    private String question;
    private InterviewType interviewType;
    private Long AssQuestionInterviewId;
}
