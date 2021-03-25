package com.example.spenditTask.controllers;

import com.example.spenditTask.models.User;
import com.example.spenditTask.services.UserAuthentificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserAuthentificationConroller {

    @Autowired 
    UserAuthentificationService userAuthentificationService; 

   
    @PostMapping("/registration")
    public String registration (@RequestBody User user)
    {  
            return userAuthentificationService.saveUserCredential(user);
            
    }
    @PutMapping("/login")
    public Object login(@RequestBody User user){
            return userAuthentificationService.logUserIn(user.getEmail(), user.getPassword());
    }
    @PutMapping("/logout")
    public String logout(@RequestBody User user){
            return userAuthentificationService.logUserOut(user.getEmail());
    }
    @PutMapping("/changepassword")
    public String changePassword(@RequestBody User user){
            return userAuthentificationService.changeUserPassword(user.getEmail(),user.getPassword());
    }
    @PostMapping("/resetpassword")
    public String resetPassword(@RequestBody User user){
            return userAuthentificationService.resetUserPassword(user.getEmail());
    }



}