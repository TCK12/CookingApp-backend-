package phoebe.tck.cookingapp.service;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import phoebe.tck.cookingapp.dto.request.DishCreationRequest;
import phoebe.tck.cookingapp.dto.request.UserCreationRequest;
import phoebe.tck.cookingapp.dto.response.DishResponse;
import phoebe.tck.cookingapp.dto.response.UserResponse;
import phoebe.tck.cookingapp.entity.Category;
import phoebe.tck.cookingapp.entity.Dish;
import phoebe.tck.cookingapp.entity.User;
import phoebe.tck.cookingapp.exception.AppException;
import phoebe.tck.cookingapp.exception.ErrorCode;
import phoebe.tck.cookingapp.mapper.DishMapper;
import phoebe.tck.cookingapp.mapper.UserMapper;
import phoebe.tck.cookingapp.repository.CategoryRepository;
import phoebe.tck.cookingapp.repository.DishRepository;
import phoebe.tck.cookingapp.repository.UserRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class DishService {
    DishRepository dishRepository;
    DishMapper dishMapper;
    CategoryRepository categoryRepository;

    public DishResponse createDish(DishCreationRequest request) {
        if (dishRepository.existsByName(request.getName()))
            throw new AppException(ErrorCode.DISH_EXISTED);

        Category category = categoryRepository.findById(request.getCategory())
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_INVALID));

        Dish dish = dishMapper.toDish(request);
        dish.setCategory(category);

        dishRepository.save(dish);
        return dishMapper.toDishResponse(dish);
    }

    public List<DishResponse> getDish() {
        List<Dish> dish = dishRepository.findAll();

        return dish.stream().map(dishMapper::toDishResponse).toList();
    }

    public List<DishResponse> getDishesByCategory(Long categoryId) {
        List<Dish> dishes = dishRepository.findByCategoryId(categoryId);
        return dishes.stream().map(dishMapper::toDishResponse).toList();
    }

    public List<DishResponse> searchDishes(String query) {
        List<Dish> dishes = dishRepository.findByNameContainingIgnoreCase(query);
        return dishes.stream().map(dishMapper::toDishResponse).toList();
    }

    public DishResponse getDishById(String id) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.DISH_NOT_FOUND));
        return dishMapper.toDishResponse(dish);
    }
}
