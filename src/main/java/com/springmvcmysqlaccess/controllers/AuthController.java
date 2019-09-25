package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.models.User;
import com.springmvcmysqlaccess.security.Auth;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm(Model m) {
        if (Auth.isLoggedIn()) return "redirect:/classes";
        m.addAttribute("command", new User());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String checkCredentials (@ModelAttribute("user") User user, Model m) {
        String email = user.getEmail();
        String password = user.getPassword();
        if (Auth.login(email, password)) return "redirect:/users";
        user.setPassword("");
        m.addAttribute("command", user);
        m.addAttribute("error", "Invalid credentials.");
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout (Model m) {
        Auth.logout();
        m.addAttribute("command", new User());
        return "login";
    }
}