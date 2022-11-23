package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.jpaService.JpaDonationService;
import pl.coderslab.charity.services.jpaService.JpaInstitutionService;

import java.util.List;


@Controller
public class HomeController {

    public JpaInstitutionService jpaInstitutionService;
    public JpaDonationService jpaDonationService;

    @Autowired
    public HomeController(JpaInstitutionService jpaInstitutionService, JpaDonationService jpaDonationService) {
        this.jpaInstitutionService = jpaInstitutionService;
        this.jpaDonationService = jpaDonationService;
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return jpaInstitutionService.getAll();
    }

    @ModelAttribute("donationsCount")
    public Long donationsCount() {
        return jpaDonationService.countAll();
    }

    @ModelAttribute("donationsSum")
    public Integer donationsSumQuantity() {
        return jpaDonationService.sumQuantity();
    }

    @GetMapping
    public String homeAction(Model model) {
        return "index";
    }
}
