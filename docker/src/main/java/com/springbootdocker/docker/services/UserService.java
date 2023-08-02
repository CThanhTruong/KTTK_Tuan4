package com.springbootdocker.docker.services;

import com.springbootdocker.docker.models.User;
import com.springbootdocker.docker.repositories.UserRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User insertUser(User user){
        return userRepository.save(user);
    }

    @Retry(name = "byRetry", fallbackMethod = "fallback")

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void fallback(){
        System.out.println("Request Fail");
    }
}
