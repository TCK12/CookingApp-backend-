package phoebe.tck.cookingapp.dto.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DishCreationRequest {
    String name;
    String author;
    Long category;
    double rating;
    int time;
    int difficulty;
    String imageUrl;
    List<String> ingredients;
    List<String> quantity;
    List<String> recipes;
}
