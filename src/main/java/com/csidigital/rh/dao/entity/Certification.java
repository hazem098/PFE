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

public class Certification {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @Column(name = "CertificationObtainedDate")
    private LocalDate certificationObtainedDate;
    @Column(name = "certificationTitle")
    private String certificationTitle;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "technicalFileId")
    private TechnicalFile technicalFile;

}
