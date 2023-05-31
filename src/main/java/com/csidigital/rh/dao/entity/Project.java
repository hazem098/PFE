package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.ProjectStatus;
import com.csidigital.rh.shared.enumeration.ProjectType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String projectReference;
    private String name;
    private String description;
    private Double budget;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate startDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)

    private ProjectType projectType;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @JsonIgnore
    @ManyToMany(mappedBy = "project")
    List<Resource> resources ;
    @JsonIgnore
    @OneToOne(mappedBy = "prj")
    private Resource responsable;
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private List<Task> tasks;
}

