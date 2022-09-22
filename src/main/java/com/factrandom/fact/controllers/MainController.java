package com.factrandom.fact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.factrandom.fact.services.ApiService;

@Controller
public class MainController {
    
    @Autowired
    ApiService apiService;

    @GetMapping("/login")
    public String showLogin(Model model){
        return "login";
    }

    @GetMapping("/fact")
    public String getFact(Model model) throws Exception{
        String fact = apiService.getRandomFact();
        model.addAttribute("fact", fact);
        return "fact";
    }
}
