package com.csidigital.rh.shared.dto.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class ExperienceRequest {
    private LocalDate experienceStartDate; //getMonth()
    private LocalDate experienceEndDate;
    private Boolean actualEmployment;
    private String  experienceCompany;
    private String  experienceRole;
    private String  technology;
    private String  experienceTitle;
    private String  experiencePost ;
    private Long technicalFileId ;

}