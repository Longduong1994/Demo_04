package demo_04.model.dto.request;

import demo_04.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuRequest {
    private Long id;
    private String name;
    private MultipartFile image;
    private String description;
    private double price;
    private Category category;
}
