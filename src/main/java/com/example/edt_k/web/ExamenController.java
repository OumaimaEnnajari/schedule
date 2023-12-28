package com.example.edt_k.web;

import com.example.edt_k.service.ExamenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/examen")
public class ExamenController {
    private ExamenService examenService;


}
