package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name="gene")

public class Gene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    //un edt corresponf a un gene
    @OneToOne
    @JoinColumn(name = "filiere_id",referencedColumnName = "id",nullable = false,unique = true)
    private Filiere filiere;

    //one timetable contains many exams
    @OneToMany(mappedBy = "gene", cascade = CascadeType.ALL)
    private List<Examen> exams;

    @Override
    public String toString() {
        return "Gene{" +
                ", filiere=" + filiere +
                ", exams=" + exams +
                ", currentDate=" + currentDate +
                '}';
    }

    @Column(name = "date_generation")
    private LocalDateTime currentDate;
    public Gene(){
        this.exams=new ArrayList<>();

    }
}
