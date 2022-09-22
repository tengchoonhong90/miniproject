package com.factrandom.fact.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factrandom.fact.repositories.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    public String getUser(String user) {
        return userRepo.getUser(user);
    }
    
    public void addFact(String user, String fact){
        userRepo.addFactToRepo(user, fact);
    }
}
