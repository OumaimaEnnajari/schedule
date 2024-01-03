package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Override
    public String toString() {
        return "Examen{" +
                "id=" + id +
                ", profs=" + profs +
                ", salles=" + salles +
                ", examTime=" + examTime +
                ", module=" + module +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Examen")
    private long id;

    @OneToMany(mappedBy = "examen",fetch = FetchType.LAZY)
    private Set<Prof> profs;

    @OneToMany(mappedBy = "examen",fetch = FetchType.LAZY)
    private Set<Salle> salles;

    @OneToOne
    private Exam_time examTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "module_id", referencedColumnName = "id_Module")
    private Module module;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "gene_id", nullable = false)
    private Gene gene;
}