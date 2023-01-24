package com.api.tweeteroapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.tweeteroapi.dto.TweetDTO;
import com.api.tweeteroapi.model.TweetModel;
import com.api.tweeteroapi.model.UserModel;
import com.api.tweeteroapi.repository.TweetRepository;
import com.api.tweeteroapi.repository.UserRepository;

@Service
public class TweetService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    public void save(String username, TweetDTO dto) {
        Optional<UserModel> user = userRepository.findByUsername(username);
        if(user.isPresent()) {
            tweetRepository.save(new TweetModel(dto, username, user.get().getPictureUrl()));
        }
    }

    public List<TweetModel> getTweets(Pageable page) {
        return tweetRepository.findAll(page).getContent();
    }

    public List<TweetModel> getUsersTweets(String username) {
        Optional<UserModel> user = userRepository.findByUsername(username);

        if(!user.isPresent()) return List.of();

        return tweetRepository.findByUsernameOrderByIdDesc(username);
    }
}
