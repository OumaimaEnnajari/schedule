package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Prof")
public class Prof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Prof")
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    // Several professors can supervise an exam at the same time
    @ManyToOne
    @JoinColumn(name = "examen_id", referencedColumnName = "id_Examen")
    private Examen examen;
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private List<Module> courses;
}