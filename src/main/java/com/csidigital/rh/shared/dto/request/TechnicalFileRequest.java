package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.shared.enumeration.Nationality;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.List;

@Data
public class TechnicalFileRequest {
    private  String reference;
    private String description;
    private String objective;
    private String driverLicense;
    private List<Skills> skills;
    private List<Experience> experiences;
    private List <Language> languages;
    private List<Certification> certifications;
    private List<Education> educations;
    private Long employeeId;
}
