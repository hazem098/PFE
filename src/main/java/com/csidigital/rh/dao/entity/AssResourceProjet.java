package com.csidigital.rh.dao.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class AssResourceProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
