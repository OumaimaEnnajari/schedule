package com.example.edt_k.DTO;

import com.example.edt_k.entity.Exam_Time;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Exam_Time_DTO {
    private Long id_exam_time;
    private String date;
    private Duration_DTO duration;

    public static Exam_Time_DTO toDto(Exam_Time entity){
        return Exam_Time_DTO.builder()
                .id_exam_time(entity.getId())
                .date(entity.getDays().getDate())
                .duration(Duration_DTO.toDto(entity.getDuration()))
                .build();
    }

}
