package com.evandro.auth_api.services.impl;

import com.evandro.auth_api.config.TokenConfig;
import com.evandro.auth_api.dtos.AuthDto;
import com.evandro.auth_api.dtos.TokenDto;
import com.evandro.auth_api.models.User;
import com.evandro.auth_api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenConfig tokenConfig;

    @Override
    public TokenDto auth(AuthDto authDto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authDto.login(),authDto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenConfig.generateToken((User) auth.getPrincipal());
        return new TokenDto(token);
    }
}
