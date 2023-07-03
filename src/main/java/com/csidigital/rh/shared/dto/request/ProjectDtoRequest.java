package com.csidigital.rh.shared.dto.request;


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
public class ProjectDtoRequest {
    private String projectReference;
    private String name;
    private String description;
    private Double budget;
    private LocalDate startDate;
    private Integer workingHourNumber ;
    private LocalDate realStartDate ;
    private LocalDate realEndDate ;
    private String projectCategory ;
    private ProjectType projectType;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
    private List<Long> resourceIds;

}
