package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Article;
import com.csidigital.rh.dao.entity.ArticleUpdated;
import com.csidigital.rh.dao.entity.BenefitRC;
import com.csidigital.rh.dao.entity.ExceptionalFee;
import com.csidigital.rh.shared.enumeration.Status;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContractRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private String contractTitle;

    private String contractPlace;
    private LocalDate contractDate;
    private Byte[] entrepriseSignature;
    private String commentContract;
    private String contractIntroduction;


    private List<ArticleUpdated> articles  ;
    private Status contractStatus;
    private List<BenefitRC> benefitRCSList;
    private List<ExceptionalFee>  ExceptionalFeeList;
    private Long resourceId;
}
