package com.main.modules.category.application.dto.app;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AppCategoryResponse {
    private Long id;
    private String image;
    private String description;
    private String name;
}
