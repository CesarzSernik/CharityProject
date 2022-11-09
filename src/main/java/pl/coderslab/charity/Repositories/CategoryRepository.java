package pl.coderslab.charity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {


}
