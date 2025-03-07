package com.main.modules.user.application.usecase;


import com.main.modules.user.application.dto.user.RegisterRequest;
import com.main.modules.user.application.dto.auth.AuthResponse;
import com.main.modules.user.domain.model.Role;
import com.main.modules.user.domain.model.User;
import com.main.modules.user.infrastructure.repository.UserRepository;
import com.main.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtUtil;

    public AuthResponse execute(RegisterRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();

        userRepository.save(user);

        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}