package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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
    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return Objects.equals(id, salle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", capacite=" + capacite +
                ", prise=" + prise +
                ", name='" + name + '\'' +
                '}';
    }

    // In several rooms, we will find only one exam at a given time
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "examen_id", referencedColumnName = "id_Examen")
    private Examen examen;
}
