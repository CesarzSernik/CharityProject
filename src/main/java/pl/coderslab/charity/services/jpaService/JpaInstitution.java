package pl.coderslab.charity.services.jpaService;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.repositories.InstitutionRepository;
import pl.coderslab.charity.services.InstitutionService;

import java.util.List;
@Service
public class JpaInstitution implements InstitutionService {

    private final InstitutionRepository institutionRepository;

    public JpaInstitution(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> getAll() {
        return institutionRepository.findAll();
    }
}
