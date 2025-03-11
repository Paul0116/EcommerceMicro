package com.main.modules.banner.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBannerRequest {
    private String title;
    private String image;
    private String description;
}
