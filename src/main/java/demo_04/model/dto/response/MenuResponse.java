package demo_04.model.dto.response;

import demo_04.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuResponse {
    private Long id;
    private String name;
    private String image;
    private String description;
    private double price;
    private boolean status;
    private Date created_date;
    private Category category;
}
