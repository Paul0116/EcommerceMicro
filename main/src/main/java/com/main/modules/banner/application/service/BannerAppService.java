package com.main.modules.banner.application.service;

import com.main.modules.banner.application.dto.app.AppBannerResponse;
import com.main.modules.banner.application.usecase.app.GetAppBannerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerAppService {
    private final GetAppBannerUseCase getAppBannerUseCase;

    public List<AppBannerResponse> getAll(){
        return getAppBannerUseCase.execute();
    }

}
