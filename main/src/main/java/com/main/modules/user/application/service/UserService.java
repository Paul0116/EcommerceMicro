package com.main.modules.user.application.service;


import com.main.modules.user.application.dto.user.RegisterRequest;
import com.main.modules.user.application.dto.auth.AuthResponse;
import com.main.modules.user.application.dto.user.UserDetailsResponse;
import com.main.modules.user.application.usecase.GetUserByIDUseCase;
import com.main.modules.user.application.usecase.RegisterUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final RegisterUserUseCase registerUserUseCase;
    private final GetUserByIDUseCase getUserByIDUseCase;

    public AuthResponse register(RegisterRequest request) {
        return registerUserUseCase.execute(request);
    }

    public UserDetailsResponse getUserDetails(Long id) {
        return getUserByIDUseCase.execute(id);
    }

}