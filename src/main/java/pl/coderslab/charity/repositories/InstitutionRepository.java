package pl.coderslab.charity.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entities.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution,Long> {

}
