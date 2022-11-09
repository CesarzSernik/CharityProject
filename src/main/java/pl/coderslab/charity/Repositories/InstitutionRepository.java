package pl.coderslab.charity.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.Entities.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {

}
