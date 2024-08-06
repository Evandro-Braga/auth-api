package com.evandro.auth_api.controllers;

import com.evandro.auth_api.dtos.AuthDto;
import com.evandro.auth_api.dtos.TokenDto;
import com.evandro.auth_api.dtos.UserDto;
import com.evandro.auth_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth")
    public TokenDto auth(@RequestBody AuthDto authDto) {
        return authService.auth(authDto);
    }

}
