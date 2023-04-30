package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.ExternalTimeOffType;
import com.csidigital.rh.shared.enumeration.RequestStatus;
import com.csidigital.rh.shared.enumeration.TimeOffType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TimeOff {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    @Enumerated(EnumType.STRING)
    @Column(name = "timeOffType")
    private TimeOffType timeOffType;
    @Column(name = "description")
    private String description;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @Column(name = "timeOffPeriod")
    private String timeOffPeriod;
    @Column(name = "comment")
    private String comment;
    @Column(name = "requestInputDate")
    private LocalDate requestInputDate;
    @Column(name = "requestStatus")
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus;
    @Column(name = "validationDate")
    private LocalDate validationDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "externalTimeOffType")
    private ExternalTimeOffType externalTimeOffType;


}
