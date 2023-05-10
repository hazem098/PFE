package com.csidigital.rh.shared.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CertificationResponse {
    private Long id;

    private LocalDate certificationObtainedDate;
    private String certificationTitle;

    private Long technicalFileId ;

}