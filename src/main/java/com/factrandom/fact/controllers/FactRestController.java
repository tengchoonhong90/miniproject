package com.factrandom.fact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.factrandom.fact.models.Fact;
import com.factrandom.fact.services.ApiService;
import com.factrandom.fact.services.UserService;

@RestController
public class FactRestController {

    @Autowired
    ApiService apiService;

    @Autowired
    UserService userService;

    @GetMapping("/getallfacts")
    public void getallfacts(){

    }

    @PostMapping("/fact")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String addFact(@RequestBody Fact fact) {
        return addFact(fact);
    }
    
}
