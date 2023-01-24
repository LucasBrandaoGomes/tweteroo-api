package com.api.tweeteroapi.dto;

import jakarta.validation.constraints.NotBlank;

public record TweetDTO (@NotBlank String tweet){
    
}
