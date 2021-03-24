package com.example.spenditTask.services;
import com.example.spenditTask.models.User;
import com.example.spenditTask.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthentificationService {

    @Autowired
    UserRepository userRepository;

    public String ValidateUserCredential(User user) {

        if(user.getFirstName()==""|user.getLastName()==""|user.getPassword()==""|user.getEmail()=="")
                return "\""+"Fields must not be empty"+"\"";
        //Email must be unique for each User
        else if (userRepository.findByEmail(user.getEmail())!=null)
                return "\""+"user already exists.If you forget your password you can reset it"+"\"";
        else
                return "valid user";
     
    }

    public String saveUserCredential(User user){

        if (ValidateUserCredential(user)=="valid user"){
            userRepository.save(user);
            return "\"" +"user registred successfully"+"\"" ; 
        }
        else
            return ValidateUserCredential(user);
    }

    
}
