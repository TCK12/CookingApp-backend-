package phoebe.tck.cookingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import phoebe.tck.cookingapp.entity.Category;
import phoebe.tck.cookingapp.entity.Dish;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, String> {
    boolean existsByTitle(String title);
    Optional<Category> findById(Long id);
}
