package com.example.edt_k.DTO;

import com.example.edt_k.entity.Duration;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class Duration_DTO {
        private Long id;

        private String debutExamen;

        private String FinExamen;

        public static Duration_DTO toDto(Duration entity){
           return Duration_DTO.builder()
                   .id(entity.getId())
                   .debutExamen(entity.getDebutExamen())
                   .FinExamen(entity.getFinExamen())
                    .build();
        }


    }

