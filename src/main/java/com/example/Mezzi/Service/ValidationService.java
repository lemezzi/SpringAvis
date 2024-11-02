package com.example.Mezzi.Service;

import java.time.Instant;
import java.util.Random;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mezzi.Classes.User;
import com.example.Mezzi.Classes.Validation;
import com.example.Mezzi.Reposit.ValidationRepository;


@Service
public class ValidationService {
@Autowired
private ValidationRepository validationRepository;

public Validation enregistrerValidation(User user){
    Validation validation=new Validation();
    validation.setUser(user);
    Instant creation=Instant.now();
    validation.setCreation(creation);
    Instant expiration=creation.plusSeconds(3600);
    validation.setExpiration((expiration));
    
    Random random=new Random();
    int code=random.nextInt(999999);
    validation.setCode(String.valueOf(code));
    return validationRepository.save(validation);
}


public Validation lireEnFonctionDucode(String code){
    Optional<Validation> optionalValidation = validationRepository.findByCode(code);
    return optionalValidation.orElse(null);
}

    
}
