package com.main.modules.banner.application.usecase.app;

import com.main.modules.banner.application.dto.app.AppBannerResponse;
import com.main.modules.banner.domain.model.Banner;
import com.main.modules.banner.infrastructure.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAppBannerUseCase {

    private final BannerRepository bannerRepository;
    public List<AppBannerResponse> execute() {
        List<Banner> bannerData = bannerRepository.findAll();

        return bannerData.stream()
                .map(banner -> new AppBannerResponse(
                        banner.getId(),
                        banner.getImage()
                ))
                .collect(Collectors.toList());
    }
}
