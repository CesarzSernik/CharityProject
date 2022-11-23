package pl.coderslab.charity.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.entities.CurrentUser;
import pl.coderslab.charity.entities.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login/process")
    public void processLoginForm(@RequestAttribute String email, @RequestAttribute String password){

    }

    @GetMapping("/admin")
    @ResponseBody
    public String userInfo(@AuthenticationPrincipal CurrentUser customUser) {
        try {
            User entityUser = customUser.getUser();
            return "Jesteś zalogowany/a jako: " + entityUser.getEmail();
        } catch(NullPointerException e){
            return "Nie jesteś zalogowany/a jako żaden z użytkowników";
        }
    }

}
