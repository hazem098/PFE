package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.entity.Task;
import com.csidigital.rh.shared.enumeration.Priority;
import com.csidigital.rh.shared.enumeration.TaskPhase;
import com.csidigital.rh.shared.enumeration.TaskType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SousTacheResponse {
   private Long id ;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate EndDate;
    private Long estimation;
    private Long progression ;
    private TaskType taskType;
    private Priority priority;
    private TaskPhase taskPhase;
    private Resource resource;

    private Task task ;
}
