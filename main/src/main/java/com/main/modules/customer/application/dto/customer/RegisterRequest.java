package com.main.modules.customer.application.dto.customer;

import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String mobileNumber;
    private String landline;
    private String address;
    private String image;
    private String birthDate;
}