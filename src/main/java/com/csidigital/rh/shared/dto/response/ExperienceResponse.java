package com.csidigital.rh.shared.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ExperienceResponse {
    private Long Id ;
    private LocalDate startMonth; //getMonth()
    private LocalDate endMonth;
    private LocalDate startYear;
    private LocalDate endYear;
    private Boolean actualEmployment;
    private String company;
    private String role;
    private String technology;
    private String title;
    private String post ;


}
