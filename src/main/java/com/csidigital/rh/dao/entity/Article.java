package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "articleTitle")
    private String articleTitle;
    @Column(name = "description" , length = 100000)
    private String description;


    @JsonIgnore
    @ManyToMany(mappedBy = "articles")
    private List<Contract> contracts = new ArrayList<>();
}
