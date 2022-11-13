package pl.coderslab.charity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.jpaService.JpaDonation;
import pl.coderslab.charity.services.jpaService.JpaInstitution;

import java.util.List;


@Controller
public class HomeController {

    public JpaInstitution jpaInstitution;
    public JpaDonation jpaDonation;

    @Autowired
    public HomeController(JpaInstitution jpaInstitution, JpaDonation jpaDonation) {
        this.jpaInstitution = jpaInstitution;
        this.jpaDonation = jpaDonation;
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return jpaInstitution.getAll();
    }

    @ModelAttribute("donationsCount")
    public Long donationsCount() {
        return jpaDonation.countAll();
    }

    @ModelAttribute("donationsSum")
    public Integer donationsSumQuantity() {
        return jpaDonation.sumQuantity();
    }

    @GetMapping
    public String homeAction(Model model) {
        return "index";
    }
}
