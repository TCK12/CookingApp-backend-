package phoebe.tck.cookingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String name;
    String author;
    String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    double rating;
    int time;
    int difficulty;

    @ElementCollection
    List<String> ingredients;

    @ElementCollection
    List<String> quantity;

    @ElementCollection
    List<String> recipes;
}
