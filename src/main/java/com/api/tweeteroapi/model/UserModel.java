package com.api.tweeteroapi.model;

import com.api.tweeteroapi.dto.UserDTO;

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
public class UserModel {
    
    public UserModel(UserDTO data){
        this.username = data.username();
        this.pictureUrl = data.pictureUrl();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 10, nullable = false)
    private String username;

    @Column(length = 255, nullable = false)
    private String pictureUrl;
}
