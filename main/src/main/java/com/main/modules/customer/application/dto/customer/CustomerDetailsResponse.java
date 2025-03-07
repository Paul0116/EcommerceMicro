package com.main.modules.customer.application.dto.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDetailsResponse {
    private int id;
    private String email;
    private String firstname;
    private String lastname;
    private String mobileNumber;
    private String landline;
    private String address;
    private String image;
    private String birthDate;
}
