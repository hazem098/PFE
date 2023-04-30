package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class AssQuestionInterviewRequest {
    private Integer mark;
    private Long questionNum;
    private Long interviewNum;
}
