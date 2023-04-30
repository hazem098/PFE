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

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "diploma")
    private String diploma;
    @Column(name = "institution")
    private String institution;
    @Column(name = "obtainedDate")
    private LocalDate obtainedDate;
    @Column(name = "startYear")
    private LocalDate startYear;

    @Column(name = "score")
    private String score;
    @Column(name = "actual")
    private Boolean actual;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "technicalFileId")
    private TechnicalFile technicalFile;
}
