package com.example.edt_k.DTO_2;

import com.example.edt_k.DTO.Exam_Time_DTO;
import com.example.edt_k.entity.Examen;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class Examen_Dto_2 {
    private long id_examen;
    private Exam_Time_DTO examTime;
    private Module_DTO_2 module;

    public static Examen_Dto_2 dto2(Examen entity){
        return Examen_Dto_2.builder().id_examen(entity.getId()).examTime(Exam_Time_DTO.toDto(entity.getExamTime()))
                .module(Module_DTO_2.toDTO_2(entity.getModule())).build();
    }

}
