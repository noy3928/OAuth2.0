package com.trevari.oauth20.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
@Entity
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleName name;
}


