package com.example.edt_k.service;

import com.example.edt_k.entity.Module;
import com.example.edt_k.entity.Prof;
import com.example.edt_k.entity.Salle;
import com.example.edt_k.repository.ProfRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class ProfServiceImp implements ProfService{
    private ProfRepository profRepository;
    @Override
    public List<Prof> getProfs() {
        return (List<Prof>) profRepository.findAll();
    }

    @Override
    public Prof getProfByModule(Optional<Module> module) {
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
    public Prof saveProf(Prof prof) {
        return profRepository.save(prof);
    }

    @Override
    public Prof updateProfPPR(String PPR, Prof prof) {

        Optional<Prof> optionalOldProf = profRepository.getProfByPPR(PPR);

        if (optionalOldProf.isPresent()) {
            Prof oldProf = optionalOldProf.get();
            oldProf.setNom(prof.getNom());
            oldProf.setId(prof.getId());
            profRepository.save(oldProf);
            return oldProf;
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteProfPPR(String PPR) {
        Prof p=profRepository.getProfByPPR(PPR).orElse(null);
        if(p!=null) {
            profRepository.supprimerParPPR(PPR);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Prof> getByPPR(String ppr) {
        return profRepository.getProfByPPR(ppr);
    }

    @Override
    public Prof updateProf(Long id, Prof newProf) {
            profRepository.save(newProf);
            return newProf;

    }

    @Override
    public void deleteProf(Long id) {
        profRepository.deleteById(id);
    }

    @Override
    public Prof getById(Long id) {
        return profRepository.findById(id).orElse(null);
    }

    @Override
    public Prof random_surveillant(Optional<Module> course) {
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
    public Set<Prof> random_surveillant_list(Set<Salle> salles, Optional<Module> course) {
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
    @Override
    public List<Prof> SearchByMc(String nom) {
        return profRepository.chercherprof(nom);
    }

    @Override
    public boolean deleteProfByID(Long id) {
        Prof p=profRepository.findById(id).orElse(null);
        if(p!=null) {
            profRepository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public Set<Prof> getProfsByExamenId(Long examenId) {
        return profRepository.findByExamens_Id(examenId);
    }
    @Override
    public Prof getProfById(Long id) {
        return profRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Prof> LoadProfByUserId(Long id) {

        return profRepository.findProfByidUser(id);
    }


}
