package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "duration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Duration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "debut_exam")
    private String debutExamen;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fin_exam")
    private String FinExamen;


    @OneToMany(mappedBy = "duration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exam_Time> exam_times;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Duration duration = (Duration) o;
        return this.debutExamen.equals(duration.getDebutExamen()) && this.FinExamen.equals(duration.getFinExamen());
    }

    @Override
    public String toString() {
        return "Duration{" +
                "id=" + id +
                ", debutExamen='" + debutExamen + '\'' +
                ", FinExamen='" + FinExamen + '\'' +
                '}';
    }
}
