package com.csidigital.rh.dao.entity;

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

public class Evaluation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "globalAppreciation")
    private int globalAppreciation;

    @JsonIgnore
    @OneToMany(mappedBy = "evaluation")
    private List<OfferCandidate> OfferCandidate;


}
