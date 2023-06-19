package com.csidigital.rh.shared.dto.response;



import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.shared.enumeration.Priority;
import com.csidigital.rh.shared.enumeration.TaskPhase;
import com.csidigital.rh.shared.enumeration.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
    private Long progression ;
    private Long TimeSpent ;
    private LocalDate creationDate ;
    private String reference;
    private TaskType taskType;
    private Priority priority;
    private TaskPhase taskPhase;
    private LocalDate realEndDate ;
    private LocalDate projectionDate;
    private Project project;


    private List<SubTask> sousTaches ;
}
