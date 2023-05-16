package com.csidigital.rh.shared.dto.request;


import com.csidigital.rh.shared.enumeration.Priority;
import com.csidigital.rh.shared.enumeration.TaskPhase;
import com.csidigital.rh.shared.enumeration.TaskType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDtoRequest {
    private String title;
    private String description;
    private Date startDate;
    private Long estimation;
    private String reference;
    private TaskType taskType;
    private Priority priority;
    private TaskPhase taskPhase;
}
