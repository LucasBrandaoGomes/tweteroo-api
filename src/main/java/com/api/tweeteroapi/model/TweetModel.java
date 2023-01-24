package com.api.tweeteroapi.model;

import com.api.tweeteroapi.dto.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class TweetModel {
    
    public TweetModel(TweetDTO data, String username, String pictureUrl){
        this.tweet = data.tweet();
        this.username = username;
        this.pictureUrl = pictureUrl;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(length = 50, nullable = false)
    String username;

    @Column(length = 200, nullable = false)
    String tweet;

    @Column(length = 140, nullable = false)
    String pictureUrl;
}
 

