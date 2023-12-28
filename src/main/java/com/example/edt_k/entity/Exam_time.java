package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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

    @Column(name = "duration_minutes")
    private int durationMinutes;

    // In a specific meeting time, we will have only one exam
    @OneToOne(mappedBy = "examTime")
    private Examen examen;
}
