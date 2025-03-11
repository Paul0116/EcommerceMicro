package com.main.modules.customer.application.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String mobileNumber;
    private String landline;
    private String address;
    private String image;
    private String birthDate;
    private String loginTimestamp;
}
