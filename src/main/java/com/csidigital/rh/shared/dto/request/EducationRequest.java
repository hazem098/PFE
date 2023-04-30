package com.csidigital.rh.shared.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EducationRequest {
    private String diploma;
    private String institution;
    private LocalDate obtainedDate;
    private LocalDate startYear;
    private String score;
    private Boolean actual;
    private Long technicalFileId ;
}
