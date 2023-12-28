package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salle")
@Getter
@Setter
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Salle")
    private Long id;

    @Column(name = "capacite", nullable = false)
    private int capacite;

    @Column(name = "prise", nullable = false)
    private boolean prise;

    // In several rooms, we will find only one exam at a given time
    @ManyToOne(optional = false)
    @JoinColumn(name = "examen_id", referencedColumnName = "id_Examen")
    private Examen examen;
}
