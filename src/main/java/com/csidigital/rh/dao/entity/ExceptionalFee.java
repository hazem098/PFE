package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.Currency;
import com.csidigital.rh.shared.enumeration.FeeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExceptionalFee {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private FeeType feeType;
    private String shortDescription;
    private Long amount;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String name;


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;


}
