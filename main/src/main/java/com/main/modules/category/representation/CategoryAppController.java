package com.main.modules.category.representation;

import com.main.common.ApiResponse;
import com.main.modules.category.application.dto.app.AppCategoryResponse;
import com.main.modules.category.application.service.CategoryAppService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category/app")
@RequiredArgsConstructor
public class CategoryAppController {

    private final CategoryAppService categoryAppService;

    @GetMapping("/get_all")
    public ResponseEntity<ApiResponse<List<AppCategoryResponse>>> getAll(){
        try{
            List<AppCategoryResponse> response = categoryAppService.getAll();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ApiResponse<>(HttpStatus.OK.value(), "Category retrieved successfully", response));

        } catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null));
        }
    }
}
