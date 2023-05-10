package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.TechnicalFile;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NonNull;

@Data
public class SkillsRequest {

    private String skillsTitle;

    private Long technicalFileId ;
  //  private Long skillsCategoryId ;
}
