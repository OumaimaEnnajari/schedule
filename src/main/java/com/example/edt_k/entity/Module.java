package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    // Many modules can be associated with one filiere
    @ManyToOne(optional = false)
    @JoinColumn(name = "filiere_id", referencedColumnName = "id_filiere")
    private Filiere filiere;

    // One module has one associated exam
    @OneToOne(mappedBy = "module")
    private Examen examen;
    @ManyToOne(optional = false)
    @JoinColumn(name = "prof_id", referencedColumnName = "id_Prof", unique = true)
    private Prof prof;

}