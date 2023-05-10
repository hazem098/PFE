package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CertificationRequest {

    private LocalDate certificationObtainedDate;
    private String certificationTitle;

    private Long technicalFileId ;

}
