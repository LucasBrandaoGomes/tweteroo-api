package com.api.tweeteroapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweeteroapi.dto.UserDTO;
import com.api.tweeteroapi.model.UserModel;
import com.api.tweeteroapi.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/sign-up")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public void create(@RequestBody UserDTO req){
        service.save(req);
    }

    @GetMapping
    public List<UserModel> listAll(){
        return service.findall();
    }
}
