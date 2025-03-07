package com.main.modules.customer.application.usecase;

import com.main.modules.customer.application.dto.customer.CustomerDetailsResponse;
import com.main.modules.customer.application.dtoConverter.CustomerDetailsDtoConverter;
import com.main.modules.customer.domain.model.Customer;
import com.main.modules.customer.infrastructure.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCustomerByIDUseCase {

    private final CustomerRepository customerRepository;
    private final CustomerDetailsDtoConverter userDetailsDtoConverter;

    public CustomerDetailsResponse execute(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        return userDetailsDtoConverter.convert(customer);
    }

}
