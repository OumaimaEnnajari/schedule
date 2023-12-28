package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "filiere")
public class Filiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filiere")
    private Long id;

    @Column(name = "nom_filiere", nullable = false)
    private String nom_filiere;

    @Column(name = "effectif", nullable = false)
    private int effectif;

    @OneToMany(mappedBy = "filiere")
    private List<Module> modules;}