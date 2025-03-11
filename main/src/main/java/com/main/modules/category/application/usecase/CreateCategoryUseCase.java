package com.main.modules.category.application.usecase;

import com.main.modules.category.application.dto.CategoryResponse;
import com.main.modules.category.application.dto.CreateCategoryRequest;
import com.main.modules.category.application.dtoConverter.CategoryResponseDtoConverter;
import com.main.modules.category.domain.exception.CategoryAlreadyExistsException;
import com.main.modules.category.domain.model.Category;
import com.main.modules.category.infrastructure.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;

    private final CategoryResponseDtoConverter categoryResponseDtoConverter;

    public CategoryResponse execute(CreateCategoryRequest createCategoryRequest){
        if(categoryRepository.findByName(createCategoryRequest.getName()).isPresent()){
            throw new CategoryAlreadyExistsException("Category Already exists");
        }

        Category category = Category.builder()
                .name(createCategoryRequest.getName())
                .image(createCategoryRequest.getImage())
                .description(createCategoryRequest.getDescription())
                .build();

        Category savedCategory = categoryRepository.save(category);

        return categoryResponseDtoConverter.convert(savedCategory);

    }


}
