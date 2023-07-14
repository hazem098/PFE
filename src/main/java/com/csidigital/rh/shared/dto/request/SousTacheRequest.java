package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.Priority;
import com.csidigital.rh.shared.enumeration.TaskPhase;
import com.csidigital.rh.shared.enumeration.TaskType;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class SousTacheRequest {
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate EndDate;
    private Long estimation;
    private Long progression ;
    private TaskType taskType;
    private Priority priority;
    private TaskPhase taskPhase;
    private Long resourceNum ;
    private Integer remaining ;
    private LocalDate realStartDate;
    private LocalDate realEndDate;
    private Date creationDate ;
    private LocalDate projectionDate;
    private Long taskNum;
    private String subTaskReference;
}
