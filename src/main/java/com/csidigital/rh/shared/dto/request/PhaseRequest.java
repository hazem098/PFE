package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class PhaseRequest {


    private String name ;
    @Column(length = 10000)
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(length = 10000)
    private String livrable;


}
