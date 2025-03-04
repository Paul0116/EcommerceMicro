package com.userservice.web.controller;

import com.userservice.application.dto.RegisterRequest;
import com.userservice.application.dto.AuthResponse;
import com.userservice.application.dto.UserDetailsResponse;
import com.userservice.application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody RegisterRequest request) {
        return userService.authenticate(request);
    }

    @GetMapping("/get-by-id")
    @ResponseStatus(HttpStatus.OK)
    public UserDetailsResponse getUserDetailsByID(@RequestParam Long id){
        return userService.getUserDetails(id);
    }

}