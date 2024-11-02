package com.example.Mezzi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.Mezzi.Classes.Avis;
import com.example.Mezzi.Reposit.AvisRepository;
import java.util.List;

@Service
public class AvisService {

    @Autowired
    private AvisRepository avisRepository;

    public List<Avis> getAllAvis(){
        return avisRepository.findAll();}


    @ResponseStatus(HttpStatus.CREATED)
    public void addAvis(Avis avis){
        avisRepository.save(avis);
    }

    public void supprimerAvis(Long id){
        avisRepository.deleteById(id);
    }




    
}
