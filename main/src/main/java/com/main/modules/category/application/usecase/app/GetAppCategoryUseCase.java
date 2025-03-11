package com.main.modules.category.application.usecase.app;

import com.main.modules.category.application.dto.app.AppCategoryResponse;
import com.main.modules.category.domain.model.Category;
import com.main.modules.category.infrastructure.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetAppCategoryUseCase {

    private final CategoryRepository categoryRepository;

    public List<AppCategoryResponse> execute(){
        List<Category> categoryData = categoryRepository.findAll();

        return categoryData.stream()
                .map(category -> new AppCategoryResponse(
                        category.getId(),
                        category.getImage(),
                        category.getDescription(),
                        category.getName()
                ))
                .collect(Collectors.toList());
    }


}
