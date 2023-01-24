package com.api.tweeteroapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.tweeteroapi.dto.TweetDTO;
import com.api.tweeteroapi.model.TweetModel;
import com.api.tweeteroapi.services.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/tweets")
public class TweetController {
    
    @Autowired TweetService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestHeader("User") String username, @RequestBody TweetDTO req){
        service.save(username, req);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public Page<TweetModel> getFiveTweets(@RequestParam String page){
        int pageNumber = Integer.parseInt(page);
        Pageable sortedById = PageRequest.of(pageNumber, 5, Sort.by("id").descending());
        return service.getTweets(sortedById);
    }

    @GetMapping("/username")
    public List<TweetModel> getAllUserTweets(@PathVariable String username){
        return service.getUsersTweets(username);
    }
}
