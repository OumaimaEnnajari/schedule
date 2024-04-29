package com.example.edt_k.DTO;

import com.example.edt_k.entity.Salle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salle_DTO {

    private Long id;
    private String name;

    public static Salle_DTO toDto(Salle entity){
        return Salle_DTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
    public static Salle_DTO toDto3(Salle entity){
        return Salle_DTO.builder()
                .name(entity.getName()).build();
    }
    public static Set<Salle_DTO> toDto_2(Set<Salle> entity){
        Set<Salle_DTO> salleDto = new HashSet<>();
        for (Salle salle: entity
             ) {
            salleDto.add(toDto3(salle));
        }
        return salleDto;
    }
}
