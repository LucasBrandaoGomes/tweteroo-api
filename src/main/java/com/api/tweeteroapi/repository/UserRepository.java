package com.api.tweeteroapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.tweeteroapi.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
    
    Optional<UserModel> findByUsername(String username);
}
