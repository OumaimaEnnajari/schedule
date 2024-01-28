package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "exam_Time")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam_Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "days_id", referencedColumnName = "id")
    private Days days;

    @ManyToOne
    @JoinColumn(name = "duration_id", referencedColumnName = "id")
    private Duration duration;
}
