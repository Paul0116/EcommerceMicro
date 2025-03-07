package com.main.modules.user.application.usecase;

import com.main.modules.user.application.dto.user.UserDetailsResponse;
import com.main.modules.user.application.dtoConverter.UserDetailsDtoConverter;
import com.main.modules.user.domain.model.User;
import com.main.modules.user.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserByIDUseCase {

    private final UserRepository userRepository;
    private final UserDetailsDtoConverter userDetailsDtoConverter;

    public UserDetailsResponse execute(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userDetailsDtoConverter.convert(user);
    }

}
