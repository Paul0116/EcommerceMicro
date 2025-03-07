package com.main.modules.user.application.dtoConverter;

import com.main.modules.user.application.dto.user.UserDetailsResponse;
import com.main.modules.user.domain.model.User;
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