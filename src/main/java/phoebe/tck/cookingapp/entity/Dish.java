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

    // Tên món an
    String name;

    // Tác giả
    String author;

    // Đường dẫn hình ảnh
    String imageUrl;

    // Thể loại (món Việt, món Âu,...)

    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

    // rating món ăn
    double rating;

    // Thời gian thực hiện (tính bằng phút)
    int time;

    // Độ khó (0, 1, 2) - (dễ, trung bình, khó)
    int difficulty;

    // Danh sách tên các nguyên liệu cần dùng
    @ElementCollection
    List<String> ingredients;

    // Danh số số lượng tương ứng với nguyên liệu (500gr, 2 củ,...)
    @ElementCollection
    List<String> quantity;

    // Mô tả các bước thực hiện
    @ElementCollection
    List<String> recipes;
}
