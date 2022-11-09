package pl.coderslab.charity.Services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.Entities.Institution;

import java.util.List;

@Service
public interface InstitutionService {

    List<Institution> getAll();
}
