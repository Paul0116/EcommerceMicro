package com.main.modules.banner.application.dtoConverter;

import com.main.modules.banner.application.dto.BannerResponse;
import com.main.modules.banner.domain.model.Banner;
import org.springframework.stereotype.Component;

@Component
public class BannerResponseDtoConverter {

    public BannerResponse convert(Banner banner){
        return new BannerResponse(
                banner.getId(),
                banner.getDescription(),
                banner.getTitle(),
                banner.getImage()
        );
    }
}
