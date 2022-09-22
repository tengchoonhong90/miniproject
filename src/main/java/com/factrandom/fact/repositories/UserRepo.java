package com.factrandom.fact.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {
    
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public String getUser(String user) {
       return redisTemplate.opsForValue().get(user);
    }

    public void addFactToRepo(String user, String fact) {
        redisTemplate.opsForValue().set(user, fact);
    }
}
