package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.jpaService.JpaUserService;

@Controller
public class RegisterController {

    public JpaUserService jpaUserService;
    public UserRepository userRepository;

    @Autowired
    public RegisterController(JpaUserService jpaUserService, UserRepository userRepository) {
        this.jpaUserService = jpaUserService;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping("/register/save")
    public String processRegisterForm(@ModelAttribute("newUser") User user, @RequestParam String password2) {
        try {
            if (user.getPassword().equals(password2)) {
                jpaUserService.create(user);
                return "redirect:/register/success";
            }
            return "redirect:/register";
        } catch (NullPointerException e) {
            return "redirect:/register";
        }
    }

    @RequestMapping("/register/success")
    public String successScreenForRegisterForm() {
        return "regSuccess";
    }

    @GetMapping("/create-user")
    @ResponseBody
    public String createUser() {
        User user = new User();
        user.setName("User");
        user.setSurname("Userus");
        user.setEmail("user@charity.pl");
        user.setPassword("user");
        jpaUserService.create(user);
        return "user";
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setName("Admin");
        user.setSurname("Adminus");
        user.setEmail("admin@charity.pl");
        user.setPassword("admin");
        jpaUserService.create(user);
        return "admin";
    }
}
