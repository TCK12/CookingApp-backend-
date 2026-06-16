package phoebe.tck.cookingapp.controller;


import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import phoebe.tck.cookingapp.dto.request.DishCreationRequest;
import phoebe.tck.cookingapp.dto.request.UserCreationRequest;
import phoebe.tck.cookingapp.dto.response.ApiResponse;
import phoebe.tck.cookingapp.dto.response.DishResponse;
import phoebe.tck.cookingapp.dto.response.UserResponse;
import phoebe.tck.cookingapp.service.DishService;
import phoebe.tck.cookingapp.service.UserService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RestController
@Builder
@RequestMapping("/dish")
public class DishController {
    DishService dishService;

    @PostMapping
    ApiResponse<DishResponse> createDish(@RequestBody DishCreationRequest request) {
        return ApiResponse.<DishResponse>builder().result(dishService.createDish(request)).build();
    }

    @GetMapping
    ApiResponse<List<DishResponse>> getDish() {
        return ApiResponse.<List<DishResponse>>builder()
                .result(dishService.getDish())
                .build();
    }

    @GetMapping("/category/{categoryId}")
    ApiResponse<List<DishResponse>> getDishesByCategory(@PathVariable("categoryId") Long categoryId) {
        return ApiResponse.<List<DishResponse>>builder()
                .result(dishService.getDishesByCategory(categoryId))
                .build();
    }

    @GetMapping("/search")
    ApiResponse<List<DishResponse>> searchDishes(@RequestParam("query") String query) {
        return ApiResponse.<List<DishResponse>>builder()
                .result(dishService.searchDishes(query))
                .build();
    }

    @GetMapping("/{id}")
    ApiResponse<DishResponse> getDishById(@PathVariable("id") String id) {
        return ApiResponse.<DishResponse>builder()
                .result(dishService.getDishById(id))
                .build();
    }
}
