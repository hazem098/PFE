package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.shared.enumeration.Absence;
import com.csidigital.rh.shared.enumeration.FeeType;
import com.csidigital.rh.shared.enumeration.RequestStatus;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ExpenseReportRequest {
    private LocalDate billingDate;
    private FeeType feeType;
    private Absence absence;
    private String description;
    private double amount;
    private double currency;
    private Boolean customerBilling;
    private Boolean paid;
    private RequestStatus requestStatus;
    private Boolean advance;
    private double advanceAmount;
    private double advanceRest;
    private double fixedAmount;
    private double feeSum;
}
