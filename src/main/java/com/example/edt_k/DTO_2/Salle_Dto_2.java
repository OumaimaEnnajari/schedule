package com.example.edt_k.DTO_2;

import com.example.edt_k.entity.Examen;
import com.example.edt_k.entity.Salle;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Data
@Builder
public class Salle_Dto_2 {
    private Long id;
    private String name;
    private Set<Examen_Dto_2> examens ;

    public static Set<Salle_Dto_2> toDto(Set<Salle> entity){
        Set<Salle_Dto_2> salleDto2s = new HashSet<>();
        for (Salle salle : entity) {
            Salle_Dto_2 salleDto2 = Salle_Dto_2.builder()
                    .id(salle.getId())
                    .name(salle.getName())
                    .examens(new HashSet<>())
                    .build();

            Set<Examen_Dto_2> examenDto2s = new HashSet<>();
            for (Examen examen : salle.getExamens()) {
                examenDto2s.add(Examen_Dto_2.dto2(examen));
            }
            salleDto2.setExamens(examenDto2s);
            salleDto2s.add(salleDto2);
        }
        return salleDto2s;
    }
}
