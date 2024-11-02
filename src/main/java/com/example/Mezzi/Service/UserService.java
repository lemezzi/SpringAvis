package com.example.Mezzi.Service;

import com.example.Mezzi.Classes.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Mezzi.Classes.Role;
import com.example.Mezzi.Classes.TypeDeRole;
import com.example.Mezzi.Classes.User;
import com.example.Mezzi.Reposit.UserRepository;

import java.time.Instant;
import java.util.List;
import java.util.Map;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    // Autowire BCryptPasswordEncoder to use it for encoding passwords
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    NotificationService notificationService;
    // Method to add a user
    public User addUser(User user) {
       if(! user.getEmail().contains("@")){
        throw new RuntimeException("Email invalide !");

       }
       
        // Encode the password before saving the user
        String encodedPassword = passwordEncoder.encode(user.getMdp());
        user.setMdp(encodedPassword);

        Role roleUtil=new Role();
        roleUtil.setLibelle((TypeDeRole.UTILISATEUR));
        user.setRole(roleUtil);
        User utisateur=userRepository.save(user);
        Validation valid=validationService.enregistrerValidation(user);
        notificationService.sendNotification(valid);
        

        return utisateur; 
    }

    
    
    
    
    
    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Return the list of all users
    }

    // Method to delete a user by ID
    public void supprimerUser(long id) {
        userRepository.deleteById(id); // Delete the user by ID
    }






    public void activer(Map<String, String> activation) {
        Validation validation=validationService.lireEnFonctionDucode(activation.get("code"));
        if(Instant.now().isAfter(validation.getExpiration())){
            throw new RuntimeException("votre code a ete expire");
        }

        User user=userRepository.findById(validation.getUser().getId()).orElseThrow(() -> new RuntimeException("code invalide"));
        user.setActif(true);
        userRepository.save(user);
    }
}
