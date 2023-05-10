package com.csidigital.rh.shared.dto.response;

import lombok.Data;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Data
public class SkillsResponse {
    private Long id ;
    private String skillsTitle;

    private Long technicalFileId ;
    //  private Long skillsCategoryId ;
}