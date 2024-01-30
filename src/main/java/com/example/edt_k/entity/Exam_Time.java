package com.example.edt_k.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam_Time examTime = (Exam_Time) o;
        return this.days.equals(examTime.days) && this.duration.equals(examTime.duration);
    }

    @Override
    public String toString() {
        return "Exam_Time{" +
                "id=" + id +
                ", days=" + (days != null ? days.getId() : null) +
                ", duration=" + (duration != null ? duration.getId() : null) +
                '}';
    }
}
