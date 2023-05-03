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

public class AssQuestionInterview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "mark")
    private Integer mark;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_question")
    private Question question;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_interview")
    private Interview interview;

}
