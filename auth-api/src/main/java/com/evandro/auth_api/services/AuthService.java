package com.evandro.auth_api.services;

import com.evandro.auth_api.dtos.AuthDto;
import com.evandro.auth_api.dtos.TokenDto;

public interface AuthService {

    public TokenDto auth(AuthDto authDto);
}
