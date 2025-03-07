package com.main.modules.user.application.service;

import com.main.modules.user.application.dto.auth.AuthResponse;
import com.main.modules.user.application.dto.auth.LoginRequest;
import com.main.modules.user.application.usecase.AuthenticateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticateUserUseCase authenticateUserUseCase;
    public AuthResponse authenticate(LoginRequest request) {
        return authenticateUserUseCase.execute(request);
    }
}
