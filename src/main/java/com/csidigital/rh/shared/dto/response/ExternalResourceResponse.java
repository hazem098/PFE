package com.csidigital.rh.shared.dto.response;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class ExternalResourceResponse extends EmployeeResponse{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
}

