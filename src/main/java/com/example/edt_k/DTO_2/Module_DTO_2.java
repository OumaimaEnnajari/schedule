package com.example.edt_k.DTO_2;

import com.example.edt_k.entity.Module;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class Module_DTO_2 {
    private String nom;
    public static Module_DTO_2 toDTO_2(Module entity){
        return Module_DTO_2.builder()
                .nom(entity.getNom())
                .build();
    }
}
