package com.example.edt_k.DTO;

import com.example.edt_k.DTO_2.Module_DTO_2;
import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Salle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Examen_DTO {
    private long id_examen;
    private Exam_Time_DTO examTime;
    private Module_DTO_2 module;
    private Set<Prof_DTO> profs;
    private Set<Salle_DTO> salles;

    public static Set<Examen_DTO> toDto_2(Set<Examen> examens){
        Set<Examen_DTO> examenDtos = new HashSet<>();

        for (Examen examen1 : examens) {
            Examen_DTO examenDto = Examen_DTO.builder()
                    .id_examen(examen1.getId())
                    .module(Module_DTO_2.toDTO_2(examen1.getModule()))
                    .examTime(Exam_Time_DTO.toDto(examen1.getExamTime()))
                    .salles(Salle_DTO.toDto_2(examen1.getSalles()))
                    .build();

            examenDtos.add(examenDto);
        }

        return examenDtos;
    }
    public static Examen_DTO toDto(Examen entity){
        Set<Prof_DTO> profs2= new HashSet<>();
        for (Prof prof: entity.getProfs()
        ) {
            profs2.add(Prof_DTO.toDTO(prof));

        }
        Set<Salle_DTO> salles2= new HashSet<>();
        for (Salle salle: entity.getSalles()
        ) {
            salles2.add(Salle_DTO.toDto(salle));

        }
        return Examen_DTO.builder()
                .id_examen(entity.getId())
                .module(Module_DTO_2.toDTO_2(entity.getModule()))
                .examTime(Exam_Time_DTO.toDto(entity.getExamTime()))
                .profs(profs2)
                .salles(salles2)
                .build();
    }

}
