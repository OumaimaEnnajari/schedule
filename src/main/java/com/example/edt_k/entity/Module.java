package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "module")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Module")
    private long id;

    @Column(name = "prise", nullable = false)
    private boolean prise;
    @Column(name = "nom", nullable = true)
    private String nom;

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", prise=" + prise +
                ", nom='" + nom + '\'' +
                ", prof=" + prof +
                ", semestre=" + semestre +
                '}';
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "filiere_id", referencedColumnName = "id_filiere")
    private Filiere filiere;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "module")
    private Examen examen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "prof_id", referencedColumnName = "id_Prof", unique = true)
    private Prof prof;

    @ManyToOne(optional = false)
    @JoinColumn(name = "semestre_id", referencedColumnName = "id_Semestre")
    private Semestre semestre;
}