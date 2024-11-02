package com.example.Mezzi.Controlleur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Mezzi.Classes.User;
import com.example.Mezzi.Service.UserService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    
    @PostMapping(path="inscription")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

   
    @GetMapping("/afficheUsers")
    public List<User> users(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/supprimerUser/{id}")
    public void supprimerUser(@PathVariable long id){

        userService.supprimerUser(id);
    }


    @PostMapping(path = "activation")
    public void activer(@RequestBody Map<String,String> activation){
        userService.activer(activation);
        
    }


   

}
