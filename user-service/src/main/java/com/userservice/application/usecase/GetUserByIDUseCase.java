package com.userservice.application.usecase;

import com.userservice.application.dto.UserDetailsResponse;
import com.userservice.application.dtoConverter.UserDetailsDtoConverter;
import com.userservice.domain.model.User;
import com.userservice.domain.repository.UserRepository;
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
