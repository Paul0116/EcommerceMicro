package com.main.modules.banner.representation;

import com.main.common.ApiResponse;
import com.main.modules.banner.application.dto.app.AppBannerResponse;
import com.main.modules.banner.application.service.BannerAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/banner/app")
@RequiredArgsConstructor
public class BannerAppController {

    private final BannerAppService bannerAppService;

    @GetMapping("/get_all")
    public ResponseEntity<ApiResponse<List<AppBannerResponse>>> getAll() {
        try {
            List<AppBannerResponse> response = bannerAppService.getAll();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(), "Banners retrieved successfully", response));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }
}
