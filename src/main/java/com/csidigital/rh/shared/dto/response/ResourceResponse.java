package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Contract;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ResourceResponse extends EmployeeResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String socialSecurityNumber;
    private String bankAccountNumber;

    private Double leaveBalanceRest;
    private Double leaveBalance;
    private Long productivity;
    private String nationalIdentity;
    private LocalDate recruitmentDate;
    private Boolean isEmployee;
    private List<Contract> contractsList;
    private Long projectId ;
    private Long prjId ;
}
