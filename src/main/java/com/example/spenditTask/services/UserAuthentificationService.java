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
            //After registration user must Login 
            user.setLoggedIn(false);
            userRepository.save(user);
            return "\"" +"user registred successfully"+"\"" ; 
        }
        else
            return ValidateUserCredential(user);
    }

    public Object logUserIn(String email,String password){

        try{
            User user=userRepository.findByEmailAndPassword(email,password);
            if (user==null)
                return "\"" +"email or password incorrect"+"\"" ;
            else{
                user.setLoggedIn(true);
                userRepository.save(user);
                user.setPassword("");
                return user;
            }
        }
        catch(NullPointerException e)
        {
            return e.getMessage();
        }
    }

    public String logUserOut(String email){

        try{
            User user=userRepository.findByEmail(email);
            if(user.isLoggedIn()==false)
                return "\"" + "you are already logged out !" + "\"" ;
            else {
                user.setLoggedIn(false);
                userRepository.save(user);
                return "\"" + "you are logged out !" + "\"" ;
            }
        }
        catch(NullPointerException e)
        {
            return e.getMessage();
        }

        

    }

    
    public String changeUserPassword(String email,String password){

        try{
            User user=userRepository.findByEmail(email);
            user.setPassword(password);;
            userRepository.save(user);
            return "\"" + "Password Changed !" + "\"" ;
        }
        catch(NullPointerException e)
        {
            return e.getMessage();
        }


    }

    public String resetUserPassword(String email){

        try{
            User user=userRepository.findByEmail(email);
            if(user ==null)
                return "\"" + "No user with this email exists !" + "\"" ;
            else
                return "\"" + "an email was sent to reset your password !" + "\"" ;
        }
        catch(NullPointerException e)
        {
            return e.getMessage();
        }

    }

}
