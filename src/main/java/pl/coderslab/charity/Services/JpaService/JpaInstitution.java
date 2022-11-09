package pl.coderslab.charity.Services.JpaService;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entities.Institution;
import pl.coderslab.charity.Repositories.InstitutionRepository;
import pl.coderslab.charity.Services.InstitutionService;

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
