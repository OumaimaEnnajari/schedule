package com.example.edt_k.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "days")
public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    private String date;

    @JsonIgnore
    @OneToMany(mappedBy = "days", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Exam_Time> exam_times;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Days days = (Days) o;
        return this.date.equals(days.getDate());
    }

    @Override
    public String toString() {
        return "Days{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", exam_times=" + exam_times +
                '}';
    }
}
