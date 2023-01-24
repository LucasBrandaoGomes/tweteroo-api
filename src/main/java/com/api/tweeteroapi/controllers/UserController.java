package com.api.tweeteroapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweeteroapi.dto.UserDTO;
import com.api.tweeteroapi.services.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/sign-up")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping
    public String create(@RequestBody UserDTO req){
        service.save(req);
        return "OK";
    }
}
