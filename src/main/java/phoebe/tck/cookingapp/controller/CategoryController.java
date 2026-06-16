package phoebe.tck.cookingapp.controller;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import phoebe.tck.cookingapp.dto.request.CategoryCreationRequest;
import phoebe.tck.cookingapp.dto.request.DishCreationRequest;
import phoebe.tck.cookingapp.dto.response.ApiResponse;
import phoebe.tck.cookingapp.dto.response.CategoryResponse;
import phoebe.tck.cookingapp.dto.response.DishResponse;
import phoebe.tck.cookingapp.service.CategoryService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@Builder
@RequestMapping("/category")
public class CategoryController {
    CategoryService categoryService;

    @PostMapping
    ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryCreationRequest request) {
        return ApiResponse.<CategoryResponse>builder().result(categoryService.createCategory(request)).build();
    }

    @GetMapping
    ApiResponse<List<CategoryResponse>> getCategories() {
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getCategories())
                .build();
    }
}
