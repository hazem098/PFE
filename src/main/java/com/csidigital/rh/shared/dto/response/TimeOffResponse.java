package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.ExternalTimeOffType;
import com.csidigital.rh.shared.enumeration.RequestStatus;
import com.csidigital.rh.shared.enumeration.TimeOffType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
@Data

public class TimeOffResponse {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private TimeOffType timeOffType;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String timeOffPeriod;
    private String comment;
    private LocalDate requestInputDate;
    private RequestStatus requestStatus;
    private LocalDate validationDate;
    private ExternalTimeOffType externalTimeOffType;
}
