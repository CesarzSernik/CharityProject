package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.Category;
import pl.coderslab.charity.entities.Institution;
import pl.coderslab.charity.services.jpaService.JpaCategory;
import pl.coderslab.charity.services.jpaService.JpaDonation;
import pl.coderslab.charity.services.jpaService.JpaInstitution;

import java.util.List;

@Controller
public class DonationController {

    public JpaInstitution jpaInstitution;
    public JpaDonation jpaDonation;

    public JpaCategory jpaCategory;

    @Autowired
    public DonationController(JpaInstitution jpaInstitution, JpaDonation jpaDonation, JpaCategory jpaCategory) {
        this.jpaInstitution = jpaInstitution;
        this.jpaDonation = jpaDonation;
        this.jpaCategory = jpaCategory;
    }

    @ModelAttribute("institutions")
    public List<Institution> InstitutionsList() {
        return jpaInstitution.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> CategoriesList() {
        return jpaCategory.getAll();
    }

    @RequestMapping("/donation/add")
    public String showDonationAddForm() {
        return "donation-add";
    }

//    @PostMapping("/donation/add")
//    public String processDonationAddForm() {
//        return "redirect:/";
//    }
}
