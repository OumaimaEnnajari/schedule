package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "filiere")
public class Filiere {


    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Filiere{" +
                "id=" + id +
                ", nom_filiere='" + nom_filiere + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filiere")
    private Long id;

    @Column(name = "nom_filiere", nullable = false)
    private String nom_filiere;

    @Column(name = "effectif", nullable = false)
    private int effectif;
    @JsonIgnore

    @OneToMany(mappedBy = "filiere")
    private List<Module> modules;

    @OneToOne(mappedBy = "filiere", cascade = CascadeType.ALL)
    private Gene gene;
}