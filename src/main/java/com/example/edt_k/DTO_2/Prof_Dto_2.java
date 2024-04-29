package com.example.edt_k.DTO_2;

import com.example.edt_k.entity.Prof;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Prof_Dto_2 {
    private Long id;
    private String nom;
    private Set<Salle_Dto_2> salles ;

    public static Prof_Dto_2 toDto_2(Prof entity){
        Prof_Dto_2 profDto = new Prof_Dto_2();
        profDto.setId(entity.getId());
        profDto.setNom(entity.getNom());

        // Vérification si getSalles() n'est pas null
        if (entity.getSalles() != null) {
            profDto.setSalles(Salle_Dto_2.toDto(entity.getSalles()));
        } else {
            // Si getSalles() est null, initialisez avec une liste vide
            profDto.setSalles(new HashSet<>());
        }

        return profDto;
    }
}
