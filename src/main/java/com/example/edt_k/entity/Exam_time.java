package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "exam_time")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam_time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Exam_time")
    private Long id;

    @Column(name = "day")
    @Enumerated(EnumType.STRING)
    private Day day;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "debut_exam")
    private LocalDateTime debutExamen;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam_time examTime = (Exam_time) o;
        return durationMinutes == examTime.durationMinutes && Objects.equals(id, examTime.id) && day == examTime.day && Objects.equals(debutExamen, examTime.debutExamen) && Objects.equals(examen, examTime.examen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Exam_time{" +
                "id=" + id +
                ", day=" + day +
                ", debutExamen=" + debutExamen +
                ", durationMinutes=" + durationMinutes +
                '}';
    }

    @Column(name = "duration_minutes")
    private int durationMinutes;
@JsonIgnore
    // In a specific meeting time, we will have only one exam
    @OneToOne(mappedBy = "examTime")
    private Examen examen;
}
