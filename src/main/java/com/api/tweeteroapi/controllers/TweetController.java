package com.api.tweeteroapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweeteroapi.dto.TweetDTO;
import com.api.tweeteroapi.model.TweetModel;
import com.api.tweeteroapi.services.TweetService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TweetController {
    
    @Autowired TweetService service;

    @PostMapping("/tweets")
    public ResponseEntity<Void> create(@RequestHeader("User") String username, @RequestBody @Valid TweetDTO req){
        service.save(username, req);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/tweets")
    public List<TweetModel> list(@PageableDefault(sort = "id", direction = Sort.Direction.DESC  ,page = 0, size = 5 ) Pageable page) {
       return service.getTweets(page);
    }

    @GetMapping("/tweets/{username}")
    public List<TweetModel> getAllUserTweets(@PathVariable String username){
        return service.getUsersTweets(username);
    }
}
