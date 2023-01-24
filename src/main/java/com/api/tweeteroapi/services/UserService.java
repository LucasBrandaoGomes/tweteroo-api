package com.api.tweeteroapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.tweeteroapi.dto.UserDTO;
import com.api.tweeteroapi.model.UserModel;
import com.api.tweeteroapi.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public void save(UserDTO dto) {
        repository.save(new UserModel(dto));
    }

}