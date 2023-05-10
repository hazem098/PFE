package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.shared.enumeration.OfferStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class OfferResponse {
    private Long id ;
    private String title;
    private String reference;
    private String description ;

}