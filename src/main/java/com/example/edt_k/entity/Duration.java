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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "debut_exam")
    private LocalDateTime debutExamen;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "fin_exam")
    private LocalDateTime FinExamen;

    @JsonIgnore
    @OneToMany(mappedBy = "duration", cascade = CascadeType.ALL)
    private List<Exam_Time> exam_times;
}
