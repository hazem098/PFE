package com.csidigital.rh.shared.dto.request;


import com.csidigital.rh.shared.enumeration.ProjectStatus;
import com.csidigital.rh.shared.enumeration.ProjectType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDtoRequest {
    private String projectReference;
    private String name;
    private String description;
    private Double budget;
    private Date startDate;

    private ProjectType projectType;
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

}
