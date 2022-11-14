package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entities.Donation;
import pl.coderslab.charity.services.jpaService.JpaCategory;
import pl.coderslab.charity.services.jpaService.JpaDonation;
import pl.coderslab.charity.services.jpaService.JpaInstitution;

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

    @RequestMapping("donation/add")
    public String showDonationAddForm(Model model) {
        model.addAttribute("categories", jpaCategory.getAll());
        model.addAttribute("institutions", jpaInstitution.getAll());
        model.addAttribute("donation", new Donation());
        return "donation-add";
    }

    @PostMapping("donation/save")
    public String processDonationAddForm(@ModelAttribute("donation") Donation donation) {
        jpaDonation.create(donation);
        return "redirect:/";
    }
}
