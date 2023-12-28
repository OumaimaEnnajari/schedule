package com.example.edt_k.service;

import com.example.edt_k.entity.Salle;
import com.example.edt_k.repository.SalleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class SalleServiceImp implements SalleService {
    private SalleRepository salleRepository;

    @Override
    public List<Salle> getSalles() {
        return (List<Salle>) salleRepository.findAll();
    }

    //vérifier si module demande une salle avec prise

    @Override
    public Salle random_salle(boolean avecPrise) {
        //un indice pour acceder a une salle aléatoirement
        int i=CommonServices.random_int(0,getSalles().size());
        //si le module necessite une prise
        if (avecPrise)
            //tant que la salle ne contient pas de prise donnez moi un autre indice et le module necessite prise redonner moi un indice aleatoire pour acceder a une saale aleatoire et revérifier la condition
            while(!getSalles().get(i).isPrise()){
                i=CommonServices.random_int(0,getSalles().size());
            }
        //une fois la salle avec prise est trouvé on la retourne
        return getSalles().get(i);
    }

    @Override
    public Set<Salle> random_list_salle(int effectif_fil, boolean avecPrise) {
        Set<Salle> salles = new HashSet<>();
        int capaciteSalles = 0;
        //tant que la capacité de la salle inférieur à l'effectif j'ajoute
        while (effectif_fil > capaciteSalles) {
            Salle salle = random_salle(avecPrise);
            //add retourne true si l'élément n'existait pas déjà dans la liste,
            //false s'il existe déjà dans la liste des salles à retourner
            if (salles.add(salle)) {
                //si déja insere false =>  pas d'ajout de la capacité ds la liste des salles
                capaciteSalles += salle.getCapacite();
            }
        }
        return salles;
    }
//chromosomes
    @Override
    public boolean haveCommonSalle(Set<Salle> salle1, Set<Salle> salle2) {
        for (Salle salle:salle1
             ) {
           if (salle2.contains(salle))
               return true;
        }
        return false;
    }
}
