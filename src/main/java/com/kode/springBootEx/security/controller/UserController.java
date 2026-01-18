package com.kode.springBootEx.security.controller;

import com.kode.springBootEx.security.entity.UserEntity;
import com.kode.springBootEx.security.model.User;
import com.kode.springBootEx.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("register")
    public User getUser(@RequestBody User user){
       return service.registerUser(user);
    }
}
