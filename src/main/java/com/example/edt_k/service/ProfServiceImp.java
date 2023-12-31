package com.example.edt_k.service;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.repository.ProfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProfServiceImp implements ProfService{
    private ProfRepository profRepository;
    private ModuleServiceImp moduleServiceImp;
    @Override
    public List<Prof> getProfs() {
        return (List<Prof>) profRepository.findAll();
    }

    @Override
    public Prof getProfByModule(Module module) {
        return profRepository.findProfByModules(module).get();
    }

    @Override
    public boolean haveCommonSurveillant(Set<Prof> surveillant1, Set<Prof> surveillant2) {
        for (Prof prof : surveillant1) {
            if (surveillant2.contains(prof)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Prof random_surveillant(Module course) {
        int i = CommonServices.random_int(0,getProfs().size());
        //le prof qui enseigne le module ne doit pas surveiller
        //
        while (getProfs().get(i)==getProfByModule(course)){
            i = CommonServices.random_int(0,getProfs().size());
        }
        return getProfs().get(i);
    }

    //rendre la liste des surveillants d'un module , d'une salle
    //l'ensemble des salles pour laquelle on souhaite affecter un surveilants

    @Override
    public Set<Prof> random_surveillant_list(Set<Salle> salles, Module course) {
        Set<Prof> surveillants = new HashSet<>();
        for (Salle salle:salles
        ) {
            //pour chaque salle on a un nombre de surveillants
            int nbre_surveillants= 0;
            if(salle.getName().contains("amphi")){
                while (nbre_surveillants<2){
                    if(surveillants.add(random_surveillant(course)))
                        nbre_surveillants++;
                }
            }else
                while(nbre_surveillants<1){
                    surveillants.add(random_surveillant(course));
                    nbre_surveillants++;
                }

        } return surveillants;
    }
}
