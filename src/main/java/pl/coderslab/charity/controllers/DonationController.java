package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.services.jpaService.JpaCategoryService;
import pl.coderslab.charity.services.jpaService.JpaDonationService;
import pl.coderslab.charity.services.jpaService.JpaInstitutionService;

@Controller
@RequestMapping("/donation")
public class DonationController {

    public JpaInstitutionService jpaInstitutionService;
    public JpaDonationService jpaDonationService;
    public JpaCategoryService jpaCategoryService;

    @Autowired
    public DonationController(JpaInstitutionService jpaInstitutionService, JpaDonationService jpaDonationService, JpaCategoryService jpaCategoryService) {
        this.jpaInstitutionService = jpaInstitutionService;
        this.jpaDonationService = jpaDonationService;
        this.jpaCategoryService = jpaCategoryService;
    }

    @GetMapping("/add")
    public String showDonationAddForm(Model model) {
        model.addAttribute("categories", jpaCategoryService.getAll());
        model.addAttribute("institutions", jpaInstitutionService.getAll());
        model.addAttribute("donation", new Donation());
        return "donation-add";
    }

    @PostMapping("/save")
    public String processDonationAddForm(@ModelAttribute("donation") Donation donation) {
        jpaDonationService.create(donation);
        return "donation-success";
    }


}
