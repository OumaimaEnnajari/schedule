package com.example.edt_k.service;

import com.example.edt_k.entity.Prof;

import java.util.List;

public interface ProfService {
    List<Prof> getProfs();
    Prof random_surveillant(Module module);

}
