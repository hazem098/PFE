package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Experience;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.shared.enumeration.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class EmployeeResponse {
    private Long Id ;
    private String lastName;
    private String firstName;
    private Civility civility;
    private Title title;
    private EmployeeType employeeType;
    private LocalDate birthDate;
    private String emailOne;
    private String emailTwo;
    private Integer phoneNumberOne;
    private Integer phoneNumberTwo;
    private String address;
    private Integer postCode;
    private String city;
    private String country;
    private MaritalSituation maritalSituation;
    private Integer recommendationMark ;
    private Integer experience ;
    private String experienceDetails ;
    @Enumerated(EnumType.STRING)
    private Provenance provenance;
    private String employeeFirstName;
    private String employeeLastName;
    private String EmployeeSerialNumber;
    private EmployeeStatus employeeStatus;
    @Enumerated(EnumType.STRING)
    private WorkLocation workLocation;


    private String locationName;

    private String serialNumber;

    private Set<Long> offer;
    private Departement departement;
    private TechnicalFile technicalFile ;

    private String  photo;
}
