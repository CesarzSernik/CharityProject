package pl.coderslab.charity.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.CurrentUser;
import pl.coderslab.charity.entities.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
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
