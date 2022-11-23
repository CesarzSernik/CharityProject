package pl.coderslab.charity.controllers;

import org.hibernate.ObjectNotFoundException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.CurrentUser;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.services.jpaService.JpaUser;

@Controller
public class LoginController {

    private JpaUser jpaUser;

    public LoginController(JpaUser jpaUser) {
        this.jpaUser = jpaUser;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login/process")
    public String processLoginForm(@RequestParam String username, @RequestParam String password, Model model) {
        try {
    User user = jpaUser.getByEmail(username);
    if (user.getPassword().equals(password)){
        model.addAttribute("user", user);
        return "redirect:/";
    }
        } catch (ObjectNotFoundException e){
            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal CurrentUser customUser) {
        try {
            User entityUser = customUser.getUser();
            return "Jesteś zalogowany/a jako: " + entityUser.getEmail();
        } catch (NullPointerException e) {
            return "Nie jesteś zalogowany/a jako żaden z użytkowników";
        }
    }

}
