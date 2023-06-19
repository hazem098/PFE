package com.csidigital.rh.dao.entity;



import com.csidigital.rh.shared.enumeration.Priority;
import com.csidigital.rh.shared.enumeration.TaskPhase;
import com.csidigital.rh.shared.enumeration.TaskType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate EndDate;
    private Long estimation;
    private Long progression ;
    private Long TimeSpent ;
    private LocalDate creationDate ;
    private LocalDate realEndDate ;
    private LocalDate projectionDate;
    private TaskType taskType;
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private TaskPhase taskPhase;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private List<SubTask> SubTaskList ;

}
