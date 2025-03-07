package com.main.modules.customer.application.dtoConverter;

import com.main.modules.customer.application.dto.customer.CustomerDetailsResponse;
import com.main.modules.customer.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsDtoConverter {
    public CustomerDetailsResponse convert(Customer customer) {
        return new CustomerDetailsResponse(
                customer.getId(),
                customer.getEmail(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getMobileNumber(),
                customer.getLandline(),
                customer.getAddress(),
                customer.getImage(),
                customer.getBirthDate()
        );
    }
}
