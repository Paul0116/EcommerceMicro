package com.main.modules.banner.application.service;

import com.main.modules.banner.application.dto.BannerResponse;
import com.main.modules.banner.application.dto.CreateBannerRequest;
import com.main.modules.banner.application.usecase.CreateBannerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerService {
    private final CreateBannerUseCase createBannerUseCase;

    public BannerResponse create(CreateBannerRequest createBannerRequest){
        return createBannerUseCase.execute(createBannerRequest);
    }

}
