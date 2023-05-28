package com.csidigital.rh.shared.dto.response;



import com.csidigital.rh.dao.entity.AssResourceProjet;
import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.shared.enumeration.Priority;
import com.csidigital.rh.shared.enumeration.TaskPhase;
import com.csidigital.rh.shared.enumeration.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDtoResponse {
    private long id ;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate EndDate;
    private Long estimation;
    private String reference;
    private TaskType taskType;
    private Priority priority;
    private TaskPhase taskPhase;
    private AssResourceProjet assResourceProjet ;
    private Long resourceId;
    private String ResourceN;
}
