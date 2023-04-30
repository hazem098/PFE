package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Education;
import com.csidigital.rh.dao.entity.Skills;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class SkillsCategoryRequest {

    private String title;
    /*private List<Skills> skillsList;*/
}
