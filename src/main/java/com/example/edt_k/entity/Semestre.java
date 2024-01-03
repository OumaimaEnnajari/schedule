package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Override
    public String toString() {
        return "Semestre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", debut=" + debut +
                ", fin=" + fin +
                '}';
    }

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "debut", nullable = false)
    private LocalDate debut;

    @Column(name = "fin", nullable = false)
    private LocalDate fin;
@JsonIgnore
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL)
    private List<Module> modules;

}
