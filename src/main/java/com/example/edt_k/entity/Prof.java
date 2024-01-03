package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prof prof = (Prof) o;
        return Objects.equals(id, prof.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Prof{" +
                "id=" + id +
                ", nom='" + nom + '\'' +

                '}';
    }

    @Column(name = "nom", nullable = false)
    private String nom;
@JsonIgnore
    // Several professors can supervise an exam at the same time
    @ManyToOne
    @JoinColumn(name = "examen_id", referencedColumnName = "id_Examen")
    private Examen examen;
@JsonIgnore
    @OneToMany(mappedBy = "prof", cascade = CascadeType.ALL)
    private List<Module> modules;
}