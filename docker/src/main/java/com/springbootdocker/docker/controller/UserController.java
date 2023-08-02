package com.springbootdocker.docker.controller;


import com.springbootdocker.docker.models.User;
import com.springbootdocker.docker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/API")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/insert")
    public User insert(@RequestBody User user ){
        return userService.insertUser(user);
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }
}
