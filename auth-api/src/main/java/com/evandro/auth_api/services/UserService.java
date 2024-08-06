package com.evandro.auth_api.services;

import com.evandro.auth_api.dtos.UserDto;
import com.evandro.auth_api.models.User;

import java.util.List;

public interface UserService {

    public UserDto save(UserDto userDto);
    public List<User> listUsers();
}
