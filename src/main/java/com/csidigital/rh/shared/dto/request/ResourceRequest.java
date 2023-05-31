package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Contract;
import com.csidigital.rh.dao.entity.Project;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ResourceRequest extends EmployeeRequest{


    private String socialSecurityNumber;
    private String bankAccountNumber;

    private Double leaveBalanceRest;
    private Double leaveBalance;
    private Long productivity;
    private String nationalIdentity;
    private LocalDate recruitmentDate;

    private Boolean isEmployee;

    private List<Contract> contractsList;
    private List<Long> projectNum ;

    private  Long PrjNum;
}
