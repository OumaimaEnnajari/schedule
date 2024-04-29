package com.example.edt_k.DTO;

import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Gene;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GeneDTO {
    private Long id_gene;

    //private Filiere filiere;
    private String filiereName;

    private List<Examen_DTO> exams;

    private LocalDateTime currentDate;

    public static GeneDTO toDto(Gene entity){
        List<Examen_DTO> exams2= new ArrayList<>();
        for (Examen examen: entity.getExams()
             ) {
            exams2.add(Examen_DTO.toDto(examen));

        }
        return GeneDTO.builder()
                .id_gene(entity.getId())
                .currentDate(entity.getCurrentDate())
                .filiereName(entity.getFiliere().getNom_filiere())
                .exams(exams2)
                .currentDate(entity.getCurrentDate())
                .build();
    }

}
