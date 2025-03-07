package com.main.modules.customer.application.usecase;

import com.main.modules.customer.application.dto.auth.AuthResponse;
import com.main.modules.customer.application.dto.auth.LoginRequest;
import com.main.modules.customer.domain.model.Customer;
import com.main.modules.customer.infrastructure.repository.CustomerRepository;
import com.main.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthenticateCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtUtil;

    public AuthResponse execute(LoginRequest request) {
        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPassword())) {
            throw new BadCredentialsException("Invalid credentials");
        }

        // Convert Customer to UserDetails
        UserDetails userDetails = User.withUsername(customer.getEmail())
                .password(customer.getPassword())
                .authorities("ROLE_CUSTOMER")
                .build();

        String token = jwtUtil.generateTokenCustomer(userDetails);

        return new AuthResponse(
                token,
                Math.toIntExact(customer.getId()), // Convert Long to int if needed
                customer.getEmail(),
                customer.getPassword(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getMobileNumber(),
                customer.getLandline(),
                customer.getAddress(),
                customer.getImage(),
                customer.getBirthDate(),
                "" // Set loginTimestamp if available
        );
    }
}
