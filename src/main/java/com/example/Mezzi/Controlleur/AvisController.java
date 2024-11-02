package com.example.Mezzi.Controlleur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Mezzi.Classes.Avis;
import com.example.Mezzi.Service.AvisService;

@RestController 
@RequestMapping("/")
public class AvisController {

    @Autowired
    private AvisService avisService;

    @GetMapping("/Affiche")
    public List<Avis> afficheAvis() {
        return avisService.getAllAvis();
    }

    @PostMapping(path = "ajoutAvis")
    public void ajoutAvis( @RequestBody Avis avis){
        avisService.addAvis(avis);
    }

    @DeleteMapping("/supprimerAvis/{id}")
    public void supprimerAvis(@PathVariable long id){
        avisService.supprimerAvis(id);

    }

  

    
}
