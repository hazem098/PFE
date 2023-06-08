package com.csidigital.rh.shared.dto.response;


import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.shared.enumeration.ProjectStatus;
import com.csidigital.rh.shared.enumeration.ProjectType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDtoResponse {
    private Long id;
    private String projectReference;
    private String name;
    private String description;
    private Double budget;
    private ProjectType projectType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer workingHourNumber ;
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
   private  List<Resource> resources ;
   private Resource responsable ;
}
