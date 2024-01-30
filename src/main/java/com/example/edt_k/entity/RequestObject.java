package com.example.edt_k.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestObject {
    private List<Days> daysList;
    private List<Duration> durationList;

}
