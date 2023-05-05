package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contract {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "contractTitle")
    private String contractTitle;

    @Column(name = "contractPlace")
    private String contractPlace;

    @Column(name = "contractDate")
    private LocalDate contractDate;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;

    private String commentContract;
    @Column(name = "entrepriseSignature")
    private Byte[] entrepriseSignature;

    @Enumerated(EnumType.STRING)
    private Status contractStatus;

    @Column(name = "contractIntroduction", length = 10000)
    private String contractIntroduction;
    @JsonIgnore
    @ManyToOne @JoinColumn(name = "id_resource")
    private Resource resource;


   // @JsonIgnore
    @OneToMany(mappedBy = "contract" )
    private List<ArticleUpdated> articles = new ArrayList<ArticleUpdated>();


    @JsonIgnore
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<BenefitRC> benefitRCSList;

    @JsonIgnore
    @OneToMany(mappedBy = "contract" , cascade = CascadeType.ALL)
    private List< ExceptionalFee>  ExceptionalFeeList;





}
