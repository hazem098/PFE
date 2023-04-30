package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.InterviewType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.Set;

@Data
public class QuestionResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String question;
    private InterviewType interviewType;
    private Set<Long> interview;
}
