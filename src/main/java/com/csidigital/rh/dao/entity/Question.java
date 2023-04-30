package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.InterviewType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Question {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String question;
    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;



    @OneToMany(mappedBy = "question")
    private List<AssQuestionInterview> assQuestionInterviewList ;


}




