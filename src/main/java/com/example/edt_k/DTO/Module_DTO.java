package com.example.edt_k.DTO;

import com.example.edt_k.entity.Module;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module_DTO {
    private long id_module;

    private boolean prise;

    private String nom;

    private Prof_DTO prof;


    public static Module_DTO toDTO(Module entity){
        return Module_DTO.builder()
                .id_module(entity.getId())
                .prof(Prof_DTO.toDTO(entity.getProf()))
                .prise(entity.isPrise())
                .nom(entity.getNom())
                .build();
    }

}
