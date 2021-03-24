package com.example.spenditTask.controllers;

import com.example.spenditTask.models.User;
import com.example.spenditTask.services.UserAuthentificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserAuthentificationConroller {

    @Autowired 
    UserAuthentificationService userAuthentificationService; 

   
    @PostMapping("/registration")
    public String registration (@RequestBody User user)
    {  
            return userAuthentificationService.saveUserCredential(user);
            
    }
    @PostMapping("/login")
    public String login(@RequestBody User user){
            return userAuthentificationService.logUserIn(user.getEmail(), user.getPassword());
    }
    @PutMapping("/logout")
    public String logout(@RequestBody User user){
            return userAuthentificationService.logUserOut(user.getEmail());
    }
  


}