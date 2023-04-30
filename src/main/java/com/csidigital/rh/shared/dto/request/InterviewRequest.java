package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.InterviewMode;
import com.csidigital.rh.shared.enumeration.InterviewType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class InterviewRequest {

    private LocalDate interviewDate;
    private String comment;
    private String globalMark;
    private InterviewType interviewType;
    private String duration;
    private InterviewMode interviewMode;
    private Long AssQuestionInterviewId;
}

