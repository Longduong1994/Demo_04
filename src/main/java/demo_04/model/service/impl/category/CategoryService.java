package demo_04.model.service.impl.category;

import demo_04.model.entity.Category;
import demo_04.model.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PageRanges;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;


    @Override
    public Page<Category> findAll(String name, int page, int size) {
        return categoryRepository.findAllByNameContains(name, PageRequest.of(page, size));
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        }
        return null;
    }

    @Override
    public void save(Category category) {
        category.setStatus(true);
        categoryRepository.save(category);
    }

    @Override
    public void delete(Long id) {
        if (findById(id) != null) {
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
