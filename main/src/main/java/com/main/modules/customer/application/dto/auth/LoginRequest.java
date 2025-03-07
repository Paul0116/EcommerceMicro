package com.main.modules.customer.application.dto.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}