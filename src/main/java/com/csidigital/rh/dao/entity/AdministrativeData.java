package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.AvailabilityEnum;
import com.csidigital.rh.shared.enumeration.ContractType;
import com.csidigital.rh.shared.enumeration.Experience;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdministrativeData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "contractType")
    private ContractType contractType;
    @Column(name = "currentSalary")
    private double currentSalary;
    @Column(name = "expectedSalary")
    private double expectedSalary;
    @Enumerated(EnumType.STRING)
    @Column(name = "availability")
    private AvailabilityEnum availability;
    @Column(name = "availabilityDate")
    private LocalDate availabilityDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "experience")
    private Experience experience;

}
