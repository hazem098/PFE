package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssContractArticle {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_article")
    private Article article;

    @Column(name = "articleNumber")
    private Integer articleNumber;

    @Column(name = "description" , length = 100000)
    private String description;
}
