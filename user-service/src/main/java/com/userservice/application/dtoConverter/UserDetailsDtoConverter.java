package com.userservice.application.dtoConverter;

import com.userservice.application.dto.UserDetailsResponse;
import com.userservice.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsDtoConverter {
    public UserDetailsResponse convert(User user) {
        return new UserDetailsResponse(
                user.getId(),
                user.getEmail()
        );
    }
}