package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Project;
import com.csidigital.rh.dao.entity.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
@Data
public class PhaseRequest {

    private String name ;

    private Long projectNum;

}
