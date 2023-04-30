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
    @Column(name = "title")
    private String title;
    @Column(name = "objective")
    private String objective;
    @Column(name = "driverLicense")
    private String driverLicense;
    @Column(name = "nationality")
    @Enumerated(EnumType.STRING)
    private Nationality nationality;




    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Skills> skillsList;

    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Experience> experienceList;

    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Language> languageList;

    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Certification> certificationList;

    @JsonIgnore
    @OneToMany(mappedBy = "technicalFile", cascade = CascadeType.ALL)
    private List<Education> educationList;

    @OneToOne (
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "technicalFile")
    private Employee employee;


}
