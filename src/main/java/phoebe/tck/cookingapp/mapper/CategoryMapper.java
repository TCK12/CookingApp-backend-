package phoebe.tck.cookingapp.mapper;

import org.mapstruct.Mapper;
import phoebe.tck.cookingapp.dto.request.CategoryCreationRequest;
import phoebe.tck.cookingapp.dto.request.DishCreationRequest;
import phoebe.tck.cookingapp.dto.response.CategoryResponse;
import phoebe.tck.cookingapp.dto.response.DishResponse;
import phoebe.tck.cookingapp.entity.Category;
import phoebe.tck.cookingapp.entity.Dish;

@Mapper(componentModel = "spring")

public interface CategoryMapper {
    Category toCategory(CategoryCreationRequest categoryCreationRequest);
    CategoryResponse toCategoryResponse(Category category);
}
