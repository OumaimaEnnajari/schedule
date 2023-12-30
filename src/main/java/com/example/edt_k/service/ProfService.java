package com.example.edt_k.service;

import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.entity.Module;
import java.util.List;
import java.util.Set;

public interface ProfService {
    List<Prof> getProfs();

    Prof random_surveillant(Module course);
    //générer une liste de surveillant en fonction des salles et du module
    //ces arguments car un si la salle est amphi 2 surveillant sinon 1 , si le module es enseigné avec un prof , il ne peut pas etre enseigné par ce prof
    Set<Prof> random_surveillant_list(Set<Salle> salles , Module course);

    Prof getProfByModule(Module module);
}
