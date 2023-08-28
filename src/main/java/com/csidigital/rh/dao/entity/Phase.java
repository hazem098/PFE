package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Phase {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
   private String name ;
   private String description;
   private LocalDate startDate;
   private LocalDate endDate;
   private String livrable;
   @JsonIgnore
   @ManyToOne
    private Project project;
   @JsonIgnore
   @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL)
   private List<Task> tasks;
}
