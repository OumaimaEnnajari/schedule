package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "prise", nullable = false)
    private boolean prise;
    @Column(name = "nom", nullable = true)
    private String nom;

    @Override
    public String toString() {
        return "Module{" +
                ", prise=" + prise +
                ", nom='" + nom + '\'' +
                ", prof=" + prof +

                '}';
    }
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "filiere_id", referencedColumnName = "id")
    private Filiere filiere;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "module")
    private Examen examen;
    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "prof_id", referencedColumnName = "id", unique = true)
    private Prof prof;

}