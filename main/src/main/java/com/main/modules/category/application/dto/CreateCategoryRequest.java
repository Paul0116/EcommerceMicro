package com.main.modules.category.application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateCategoryRequest {
    private String name;
    private String image;
    private String description;
}
