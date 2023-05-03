package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Article;
import com.csidigital.rh.dao.entity.ArticleUpdated;
import com.csidigital.rh.dao.entity.BenefitRC;
import com.csidigital.rh.dao.entity.ExceptionalFee;
import com.csidigital.rh.shared.enumeration.Status;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContractResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate startDate;
    private String contractTitle;
    private LocalDate endDate;
    private String contractPlace;

    private String contractIntroduction;
    private LocalDate contractDate;
    private Byte[] entrepriseSignature;
    private List<ArticleUpdated> articles ;
    private String commentContract;
    private Status contractStatus;
    private List<BenefitRC> benefitRCSList;
    private List<ExceptionalFee>  ExceptionalFeeList;
    private Long resourceId;
}
