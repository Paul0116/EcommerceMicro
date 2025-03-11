package com.main.modules.category.application.service;

import com.main.modules.category.application.dto.CategoryResponse;
import com.main.modules.category.application.dto.CreateCategoryRequest;
import com.main.modules.category.application.usecase.CreateCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CreateCategoryUseCase createCategoryUseCase;

    public CategoryResponse create(CreateCategoryRequest createCategoryRequest){
        return createCategoryUseCase.execute(createCategoryRequest);
    }

}
