package com.main.modules.category.application.dtoConverter;

import com.main.modules.category.application.dto.CategoryResponse;
import com.main.modules.category.domain.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryResponseDtoConverter {

    public CategoryResponse convert(Category category){
        return new CategoryResponse(
                category.getId(),
                category.getName(),
                category.getImage(),
                category.getDescription()
        );
    }
}
