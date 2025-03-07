package com.main.modules.customer.representation;

import com.main.common.ApiResponse;
import com.main.modules.customer.application.dto.customer.RegisterRequest;
import com.main.modules.customer.application.dto.auth.AuthResponse;
import com.main.modules.customer.application.dto.customer.CustomerDetailsResponse;
import com.main.modules.customer.application.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AuthResponse>> register(@RequestBody RegisterRequest request) {
        try {
            AuthResponse response = userService.register(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse<>(HttpStatus.CREATED.value(), "User registered successfully", response));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), e.getMessage(), null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }


    @GetMapping("/get-by-id")
    public ResponseEntity<ApiResponse<CustomerDetailsResponse>> getUserDetailsByID(@RequestParam Long id) {
        try {
            CustomerDetailsResponse response = userService.getCustomerDetails(id);
            return ResponseEntity.ok(new ApiResponse<>(HttpStatus.OK.value(), "Customer details fetched successfully", response));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), e.getMessage(), null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.NOT_FOUND.value(), "An unexpected error occurred.", null));
        }
    }
}
