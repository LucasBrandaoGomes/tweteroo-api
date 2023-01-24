package com.api.tweeteroapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tweeteroapi.model.TweetModel;

public interface TweetRepository extends JpaRepository<TweetModel, Long>{
    
    Page<TweetModel> findAllByOrderByIdDesc(Pageable pageable);
    List<TweetModel> findByUsernameOrderByIdDesc(String username);

}
