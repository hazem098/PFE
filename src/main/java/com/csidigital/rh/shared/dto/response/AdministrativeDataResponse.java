package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.AvailabilityEnum;
import com.csidigital.rh.shared.enumeration.ContractType;
import com.csidigital.rh.shared.enumeration.Experience;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdministrativeDataResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private ContractType contractType;
    private double currentSalary;
    private double expectedSalary;
    @Enumerated(EnumType.STRING)
    private AvailabilityEnum availability;
    private LocalDate availabilityDate;
    @Enumerated(EnumType.STRING)
    private Experience experience;

    }
