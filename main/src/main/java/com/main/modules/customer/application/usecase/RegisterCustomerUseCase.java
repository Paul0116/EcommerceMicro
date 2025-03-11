package com.main.modules.customer.application.usecase;

import com.main.modules.customer.application.dto.auth.AuthResponse;
import com.main.modules.customer.application.dto.customer.RegisterRequest;
import com.main.modules.customer.domain.model.Customer;
import com.main.modules.customer.infrastructure.repository.CustomerRepository;
import com.main.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCustomerUseCase {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtUtil;

    public AuthResponse execute(RegisterRequest request) {
        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        Customer customer = Customer.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .mobileNumber(request.getMobileNumber())
                .landline(request.getLandline())
                .address(request.getAddress())
                .image(request.getImage())
                .birthDate(request.getBirthDate())
                .build();

        customerRepository.save(customer);

        // Convert Customer to UserDetails
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                .withUsername(customer.getEmail())
                .password(customer.getPassword())
                .authorities("ROLE_CUSTOMER")
                .build();

        String token = jwtUtil.generateTokenCustomer(userDetails);

        return new AuthResponse(
                token,
                Math.toIntExact(customer.getId()), // Convert Long to int
                customer.getEmail(),
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
