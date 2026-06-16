package phoebe.tck.cookingapp.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import phoebe.tck.cookingapp.dto.request.DishCreationRequest;
import phoebe.tck.cookingapp.dto.request.UserCreationRequest;
import phoebe.tck.cookingapp.dto.response.CategoryResponse;
import phoebe.tck.cookingapp.dto.response.DishResponse;
import phoebe.tck.cookingapp.dto.response.UserResponse;
import phoebe.tck.cookingapp.entity.Category;
import phoebe.tck.cookingapp.entity.Dish;
import phoebe.tck.cookingapp.entity.User;

@Mapper(componentModel = "spring")
public interface DishMapper {
    @Mapping(target = "category", ignore = true)
    Dish toDish(DishCreationRequest dishCreationRequest);

    DishResponse toDishResponse(Dish dish);

    CategoryResponse toCategoryResponse(Category category);
}
