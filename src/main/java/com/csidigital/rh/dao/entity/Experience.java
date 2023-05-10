package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Experience {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private LocalDate experienceStartDate; //getMonth()
    private LocalDate experienceEndDate;
    private Boolean actualEmployment;
    private String  experienceCompany;
    private String  experienceRole;
    private String  technology;
    private String  experienceTitle;
    private String  experiencePost ;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "technicalFileId")
    private TechnicalFile technicalFile;


}