package com.csidigital.rh.dao.entity;

import jakarta.persistence.*;


@Entity
public class ProjectReferenceSequence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long nextValue;

    public ProjectReferenceSequence() {
        this.nextValue = 1L; // Initialize with the starting value
    }

    public Long getNextValue() {
        return nextValue;
    }

    public void incrementNextValue() {
        nextValue++;
    }
}
