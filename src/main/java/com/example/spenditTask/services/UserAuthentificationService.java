package com.example.spenditTask.services;
import com.example.spenditTask.models.User;
import com.example.spenditTask.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAuthentificationService {

    @Autowired
    UserRepository userRepository;

    public void saveUserCredential(User user){

        userRepository.save(user);
        
    }

    public User findUserByEmail(String email){

        return userRepository.findByEmail(email);
        
    }
    
}
