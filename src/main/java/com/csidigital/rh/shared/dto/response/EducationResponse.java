package com.csidigital.rh.shared.dto.response;

import lombok.Data;

import java.time.LocalDate;
@Data

public class EducationResponse {
    private Long Id ;
    private String diploma;
    private String institution;
    private LocalDate obtainedDate;
    private LocalDate startYear;
    private String score;
    private Boolean actual;
}
