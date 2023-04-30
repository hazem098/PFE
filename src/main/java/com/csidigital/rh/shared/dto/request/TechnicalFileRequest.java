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
    private String title;
    private String objective;
    private String driverLicense;
    private Nationality nationality;

    private List<Skills> skillsList;
    private List<Experience> experienceList;
    private List <Language> languageList;
    private List<Certification> certificationList;
    private List<Education> educationList;

}
