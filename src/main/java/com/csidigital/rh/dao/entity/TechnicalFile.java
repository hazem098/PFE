package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.Nationality;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TechnicalFile{
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "reference")
    private  String reference;
    @Column(name = "description")
    private String description;
    @Column(name = "objective")
    private String objective;
    @Column(name = "driverLicense")
    private String driverLicense;




    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Skills> skills;


    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Certification> certifications;


    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToOne (
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId")
    private Employee employee;


}