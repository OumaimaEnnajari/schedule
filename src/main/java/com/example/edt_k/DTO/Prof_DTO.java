package com.example.edt_k.DTO;

import com.example.edt_k.entity.Prof;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Prof_DTO {
    private Long id;
    private String nom;


    public static Prof_DTO toDTO(Prof entity){
        return Prof_DTO.builder()
                .id(entity.getId())
                .nom(entity.getNom())
                .build();
    }


}
