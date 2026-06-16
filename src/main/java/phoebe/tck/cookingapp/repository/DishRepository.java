package phoebe.tck.cookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phoebe.tck.cookingapp.entity.Dish;
import phoebe.tck.cookingapp.entity.User;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends JpaRepository<Dish, String> {
    boolean existsByName(String name);
    Optional<Dish> findByName(String name);
    List<Dish> findByCategoryId(Long categoryId);
    List<Dish> findByNameContainingIgnoreCase(String name);
}
