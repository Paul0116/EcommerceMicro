package com.main.modules.user.application.dto.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}