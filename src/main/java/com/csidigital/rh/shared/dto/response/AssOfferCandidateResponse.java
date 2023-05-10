package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Evaluation;
import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
@Data

public class AssOfferCandidateResponse {
    private Long id;

    private LocalDate applicationDate;
    private ExperienceLevel experienceLevel;



    private Long offerNum;
    private Long employeeNum;
    private Long evaluationNum;


}
