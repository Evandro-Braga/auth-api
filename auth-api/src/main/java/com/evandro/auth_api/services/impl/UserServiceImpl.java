package com.evandro.auth_api.services.impl;

import com.evandro.auth_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.evandro.auth_api.dtos.UserDto;
import com.evandro.auth_api.models.User;
import com.evandro.auth_api.repositories.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto save(UserDto userDto){

        if (userRepository.findByLogin(userDto.login()) != null) {
            throw new RuntimeException("Usuário já existe!");
        }

        var passwordHash = passwordEncoder.encode(userDto.password());

        User user = new User(userDto.name(),userDto.login(), passwordHash, userDto.role());

        userRepository.save(user);

        return new UserDto(user.getName(), user.getLogin(), user.getPassword(), user.getRole());
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }
    
}
