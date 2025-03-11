package com.main.modules.banner.application.usecase;


import com.main.modules.banner.application.dto.BannerResponse;
import com.main.modules.banner.application.dto.CreateBannerRequest;
import com.main.modules.banner.application.dtoConverter.BannerResponseDtoConverter;
import com.main.modules.banner.domain.exception.BannerAlreadyExistsException;
import com.main.modules.banner.domain.model.Banner;
import com.main.modules.banner.infrastructure.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CreateBannerUseCase {

    private final BannerRepository bannerRepository;

    private final BannerResponseDtoConverter bannerResponseDtoConverter;

    public BannerResponse execute(CreateBannerRequest createBannerRequest){

        if(bannerRepository.findByTitle(createBannerRequest.getTitle()).isPresent()){
            throw new BannerAlreadyExistsException("Banner already exists");
        }

        Banner banner = Banner.builder()
                .title(createBannerRequest.getTitle())
                .image(createBannerRequest.getImage())
                .description(createBannerRequest.getDescription())
                .build();

        Banner savedBanner = bannerRepository.save(banner);

        return bannerResponseDtoConverter.convert(savedBanner);

    }

}
