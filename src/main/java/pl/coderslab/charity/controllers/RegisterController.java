package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entities.User;
import pl.coderslab.charity.repositories.UserRepository;
import pl.coderslab.charity.services.jpaService.JpaUser;

@Controller
public class RegisterController {

    public JpaUser jpaUser;
    public UserRepository userRepository;

    @Autowired
    public RegisterController(JpaUser jpaUser, UserRepository userRepository) {
        this.jpaUser = jpaUser;
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register/save")
    public String processRegisterForm(@ModelAttribute("newUser") User user) {
        try {
            jpaUser.create(user);
            return "redirect:/register/success";
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
        jpaUser.create(user);
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
        jpaUser.create(user);
        return "admin";
    }
}
