package pl.coderslab.charity.services.jpaService;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.repositories.CategoryRepository;
import pl.coderslab.charity.services.CategoryService;

import java.util.List;

@Service
public class JpaCategory implements CategoryService {

    private final CategoryRepository categoryRepository;

    public JpaCategory(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
