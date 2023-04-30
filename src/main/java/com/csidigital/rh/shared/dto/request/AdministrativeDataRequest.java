package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.AvailabilityEnum;
import com.csidigital.rh.shared.enumeration.ContractType;
import com.csidigital.rh.shared.enumeration.Experience;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AdministrativeDataRequest {

    private ContractType contractType;
    private double currentSalary;
    private double expectedSalary;
    private AvailabilityEnum availability;
    private LocalDate availabilityDate;
    private Experience experience;

}
