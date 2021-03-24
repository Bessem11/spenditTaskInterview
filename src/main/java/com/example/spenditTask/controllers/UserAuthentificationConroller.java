package com.example.spenditTask.controllers;

import com.example.spenditTask.models.User;
import com.example.spenditTask.services.UserAuthentificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserAuthentificationConroller {

    @Autowired 
    UserAuthentificationService userAuthentificationService; 

    //Check if email is valid
    public String ValidateUserCredential(User user) {

        if(user.getFirstName()==""|user.getLastName()==""|user.getPassword()==""|user.getEmail()=="")
                return "\""+"Fields must not be empty"+"\"";
        //Email must be unique for each User
        else if (userAuthentificationService.findUserByEmail(user.getEmail())!=null)
                return "\""+"user already exists.If you forget your password you can reset it"+"\"";
        else
                return "valid user";
     
    }
    
    //USer Registration
    @PostMapping("/registration")
    public String registration (@RequestBody User user)
    {
             
            if (ValidateUserCredential(user)=="valid user"){
                userAuthentificationService.saveUserCredential(user);
                return "\"" +"user registred successfully"+"\"" ; 
            }
            else
                return ValidateUserCredential(user);
            
    }

}