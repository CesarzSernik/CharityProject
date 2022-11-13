package pl.coderslab.charity.services;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entities.Institution;

import java.util.List;

@Service
public interface InstitutionService {

    List<Institution> getAll();
}
