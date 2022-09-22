package com.factrandom.fact.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    private static final Logger logger = LoggerFactory.getLogger(ApiService.class);
    
    @Value("${apiKey}")
    private String apiKey;

    private static String URL = "https://numbersapi.p.rapidapi.com/random/trivia?json=true&fragment=true&max=20&min=10";
    private RestTemplate restTemplate = new RestTemplate();

    public String getRandomFact() throws Exception {
        logger.info("invoking api================");

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("X-RapidAPI-Key", "b16537a984msh92056152e90893dp1ad4ffjsnd14134918d63");
        headers.add("X-RapidAPI-Host","numbersapi.p.rapidapi.com");
        HttpEntity<?> entity = new HttpEntity<Object>(headers);
        HttpEntity<String> response = restTemplate.exchange(URL, HttpMethod.GET,entity,String.class);
        
        String[] s = response.getBody().split(",");
        String number = s[1].substring(12);
        String fact = s[0].substring(12, s[0].length() - 1);

        return number + " is " + fact;
    }

}
