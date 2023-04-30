package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.TechnicalFile;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class SkillsRequest {

    private String title;
    private Long technicalFileId ;
   /* private Long skillsCategoryId ;*/
}
