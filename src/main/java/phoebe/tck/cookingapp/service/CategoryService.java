package phoebe.tck.cookingapp.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import phoebe.tck.cookingapp.dto.request.CategoryCreationRequest;
import phoebe.tck.cookingapp.dto.request.DishCreationRequest;
import phoebe.tck.cookingapp.dto.response.CategoryResponse;
import phoebe.tck.cookingapp.dto.response.DishResponse;
import phoebe.tck.cookingapp.entity.Category;
import phoebe.tck.cookingapp.entity.Dish;
import phoebe.tck.cookingapp.exception.AppException;
import phoebe.tck.cookingapp.exception.ErrorCode;
import phoebe.tck.cookingapp.mapper.CategoryMapper;
import phoebe.tck.cookingapp.mapper.DishMapper;
import phoebe.tck.cookingapp.repository.CategoryRepository;
import phoebe.tck.cookingapp.repository.DishRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public CategoryResponse createCategory(CategoryCreationRequest request) {
        if (categoryRepository.existsByTitle(request.getTitle()))
            throw new AppException(ErrorCode.CATEGORY_EXISTED);

        Category category = categoryMapper.toCategory(request);
        categoryRepository.save(category);
        return categoryMapper.toCategoryResponse(category);
    }

    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(categoryMapper::toCategoryResponse).toList();
    }
}
