package com.userservice.application.service;

import com.userservice.application.dto.RegisterRequest;
import com.userservice.application.dto.AuthResponse;
import com.userservice.application.dto.UserDetailsResponse;
import com.userservice.application.usecase.AuthenticateUserUseCase;
import com.userservice.application.usecase.GetUserByIDUseCase;
import com.userservice.application.usecase.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RegisterUserUseCase registerUserUseCase;
    private final AuthenticateUserUseCase authenticateUserUseCase;
    private final GetUserByIDUseCase getUserByIDUseCase;

    public AuthResponse register(RegisterRequest request) {
        return registerUserUseCase.execute(request);
    }

    public AuthResponse authenticate(RegisterRequest request) {
        return authenticateUserUseCase.execute(request);
    }

    public UserDetailsResponse getUserDetails(Long id) { return getUserByIDUseCase.execute(id);}

}