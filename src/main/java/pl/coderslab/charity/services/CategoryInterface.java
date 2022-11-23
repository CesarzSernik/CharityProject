package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Category;

import java.util.List;

@Service
public interface CategoryInterface {

    List<Category> getAll();
}
