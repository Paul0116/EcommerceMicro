package com.main.modules.banner.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BannerResponse {
    private Long id;
    private String image;
    private String description;
    private String title;
}
