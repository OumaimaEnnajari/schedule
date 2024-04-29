package com.example.edt_k.DTO;

import com.example.edt_k.entity.Days;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class DaysDto {
    private Long id;

    private String date;

    public static DaysDto toDto(Days entity){
        return DaysDto.builder()
                .id(entity.getId())
                .date(entity.getDate())
                .build();
    }

}
