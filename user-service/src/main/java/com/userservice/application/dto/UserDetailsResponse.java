package com.userservice.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDetailsResponse {
    private Long id;
    private String email;
}
