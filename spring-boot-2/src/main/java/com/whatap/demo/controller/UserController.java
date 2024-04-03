package com.whatap.demo.controller;

import com.whatap.demo.jpa.UserEntity;
import com.whatap.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId:\\d+}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.findByUserId(userId));
    }
}
