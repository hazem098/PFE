package com.csidigital.rh.shared.dto.response;

import lombok.Data;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Data
public class SkillsResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private String title;
}
