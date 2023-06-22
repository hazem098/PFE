package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Phase {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
   private String name ;
   @JsonIgnore
   @ManyToOne
    private Project project;
   @JsonIgnore
   @OneToMany(mappedBy = "phase", cascade = CascadeType.ALL)
   private List<Task> tasks;
}
