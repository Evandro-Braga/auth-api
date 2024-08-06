package com.evandro.auth_api.controllers;

import com.evandro.auth_api.models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evandro.auth_api.dtos.UserDto;
import com.evandro.auth_api.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public UserDto saveNewUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    };

    @GetMapping("/user")
    public List<User> listUsers(){
        return userService.listUsers();
    }
}
