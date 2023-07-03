package com.csidigital.rh.dao.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Resource extends Employee{



    private String socialSecurityNumber;
    private String bankAccountNumber;

    private double leaveBalanceRest;
    private double leaveBalance;
    private Long productivity;
    private String nationalIdentity;
    private LocalDate recruitmentDate;
    private Boolean isEmployee;

    @OneToMany(mappedBy = "resource")
    private List<Contract> contractsList;

    @JsonIgnore
    @ManyToMany
    private List<Project> project;

    @JsonIgnore
    @OneToMany
    private List<SubTask> subTasks;
}
