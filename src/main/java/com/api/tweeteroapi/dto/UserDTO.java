package com.api.tweeteroapi.dto;

import jakarta.validation.constraints.NotBlank;

public record UserDTO (@NotBlank String username, @NotBlank String pictureUrl) {
    
}
