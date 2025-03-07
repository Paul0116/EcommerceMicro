package com.main.security;


import com.main.modules.customer.domain.model.Customer;
import com.main.modules.customer.infrastructure.repository.CustomerRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service  // ✅ Marks this class as a Spring Bean
public class CustomerDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomerDetailsServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByEmail(email);

        if (customer.isEmpty()) {
            throw new UsernameNotFoundException("Customer not found with email: " + email);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(customer.get().getEmail()) // Use email as username
                .password(customer.get().getPassword())
                .authorities("ROLE_CUSTOMER") // Assign roles if necessary
                .build();
    }
}