package com.main.modules.category.application.service;

import com.main.modules.category.application.dto.app.AppCategoryResponse;
import com.main.modules.category.application.usecase.app.GetAppCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryAppService {

    private final GetAppCategoryUseCase getAppCategoryUseCase;

    public List<AppCategoryResponse> getAll(){ return getAppCategoryUseCase.execute(); }

}
