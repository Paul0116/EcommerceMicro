package com.main.modules.customer.application.service;


import com.main.modules.customer.application.dto.auth.AuthResponse;
import com.main.modules.customer.application.dto.customer.RegisterRequest;
import com.main.modules.customer.application.dto.customer.CustomerDetailsResponse;
import com.main.modules.customer.application.usecase.GetCustomerByIDUseCase;
import com.main.modules.customer.application.usecase.RegisterCustomerUseCase;
import com.main.modules.user.application.usecase.GetUserByIDUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final GetCustomerByIDUseCase getCustomerByIDUseCase;

    public AuthResponse register(RegisterRequest request) {
        return registerCustomerUseCase.execute(request);
    }

    public CustomerDetailsResponse getCustomerDetails(Long id) {
        return getCustomerByIDUseCase.execute(id);
    }

}