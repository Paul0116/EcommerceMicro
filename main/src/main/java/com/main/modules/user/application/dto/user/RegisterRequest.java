package com.main.modules.user.application.dto.user;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
}