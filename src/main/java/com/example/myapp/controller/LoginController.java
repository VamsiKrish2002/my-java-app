package com.example.myapp.controller;

import com.example.myapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute User user, Model model) {
        String username = user.getUsername();
        String password = user.getPassword();

        // Dummy check
        if ("admin".equals(username) && "password".equals(password)) {
            logger.info("LOGIN SUCCESS: user '{}'", username);
            model.addAttribute("username", username);
            return "welcome";
        } else {
            logger.warn("LOGIN FAILED for user '{}'", username);
            model.addAttribute("error", "Invalid username or password.");
            return "login";
        }
    }
}

