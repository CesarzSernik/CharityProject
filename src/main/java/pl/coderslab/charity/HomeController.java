package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.Entities.Institution;
import pl.coderslab.charity.Repositories.InstitutionRepository;
import pl.coderslab.charity.Services.JpaService.JpaInstitution;

import java.util.List;


@Controller
public class HomeController {

    public JpaInstitution jpaInstitution;

    @Autowired
    public HomeController(JpaInstitution jpaInstitution) {
        this.jpaInstitution = jpaInstitution;
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return jpaInstitution.getAll();
    }

    @GetMapping
    public String homeAction(Model model) {
        return "index";
    }
}
