package demo_04.model.service.impl.category;

import demo_04.model.entity.Category;
import demo_04.model.service.impl.IGenericService;

import java.util.List;

public interface ICategoryService extends IGenericService<Category,Long> {
    List<Category> findAll();
}
