package com.main.modules.customer.application.service;

import com.main.modules.customer.application.dto.auth.AuthResponse;
import com.main.modules.customer.application.dto.auth.LoginRequest;
import com.main.modules.customer.application.usecase.AuthenticateCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerAuthService {
    private final AuthenticateCustomerUseCase authenticateUserUseCase;
    public AuthResponse authenticate(LoginRequest request) {
        return authenticateUserUseCase.execute(request);
    }
}
