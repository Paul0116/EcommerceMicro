package com.main.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomerDetailsServiceImpl customerDetailsService;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService,
                                   CustomerDetailsServiceImpl customerDetailsService,
                                   UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.customerDetailsService = customerDetailsService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String token = jwtService.extractToken(request);

        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            String email = jwtService.extractEmail(token);

            if (email == null || email.isBlank()) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or missing email in token");
                return;
            }

            UserDetails userDetails = null;

            // First, try to load as a Customer
            try {
                userDetails = customerDetailsService.loadUserByUsername(email);
            } catch (Exception e) {
                // If customer not found, try as a User
                try {
                    userDetails = userDetailsService.loadUserByUsername(email);
                } catch (Exception ex) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.getWriter().write("User not found with email: " + email);
                    return;
                }
            }

            if (userDetails != null && jwtService.isTokenValid(token, userDetails)) {
                var authToken = jwtService.getAuthentication(token, userDetails);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        chain.doFilter(request, response);
    }
}
