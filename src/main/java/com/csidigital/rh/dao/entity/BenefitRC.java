package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.ContractBenifitType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BenefitRC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "shortDescription")
    private String shortDescription;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "contractBenifitType")
    private ContractBenifitType contractBenifitType;

    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;
}
