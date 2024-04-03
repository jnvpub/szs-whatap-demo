package com.whatap.demo.service;

import com.whatap.demo.jpa.UserEntity;
import com.whatap.demo.jpa.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity findByUserId(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostConstruct
    public void init() {
        List<UserEntity> users = Arrays.asList(
                UserEntity.builder().userName("user1").build(),
                UserEntity.builder().userName("user2").build(),
                UserEntity.builder().userName("user3").build(),
                UserEntity.builder().userName("user4").build(),
                UserEntity.builder().userName("user5").build(),
                UserEntity.builder().userName("user6").build(),
                UserEntity.builder().userName("user7").build()
        );
        userRepository.saveAll(users);
    }
}
