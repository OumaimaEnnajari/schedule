package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "semestre")
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Semestre")
    private long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "debut", nullable = false)
    private LocalDate debut;

    @Column(name = "fin", nullable = false)
    private LocalDate fin;

    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Module> modules;
}
