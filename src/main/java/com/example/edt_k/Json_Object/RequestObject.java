package com.example.edt_k.Json_Object;

import com.example.edt_k.entity.Days;
import com.example.edt_k.entity.Duration;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RequestObject {
    private List<Days> daysList;
    private List<Duration> durationList;

}
