package phoebe.tck.cookingapp.dto.response;


import lombok.*;
import lombok.experimental.FieldDefaults;
import phoebe.tck.cookingapp.entity.Category;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DishResponse {
    String id;
    String name;
    String author;
    CategoryResponse category;
    double rating;
    int time;
    int difficulty;
    String imageUrl;
    List<String> ingredients;
    List<String> quantity;
    List<String> recipes;
}
