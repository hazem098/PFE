package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import lombok.Data;

import java.time.LocalDate;

@Data

public class AssOfferCandidateRequest {

    private LocalDate applicationDate;
    private ExperienceLevel experienceLevel;



    private Long offerNum;
    private Long employeeNum;
    private Long evaluationNum;


}
