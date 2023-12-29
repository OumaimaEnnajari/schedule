package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "examen")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Examen")
    private long id;

    @OneToMany(mappedBy = "examen")
    private Set<Prof> profs;

    @OneToMany(mappedBy = "examen")
    private Set<Salle> salles;

    @OneToOne
    private Exam_time examTime;

    @OneToOne // One exam for each module
    @JoinColumn(name = "module_id")
    private Module course;

    @ManyToOne
    @JoinColumn(name = "gene_id", nullable = false)
    private Gene gene;
}