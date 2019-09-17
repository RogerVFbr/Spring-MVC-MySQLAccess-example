package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.ProfileDao;
import com.springmvcmysqlaccess.dao.UserDao;
import com.springmvcmysqlaccess.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    UserDao userDao;

    @Autowired
    ProfileDao profileDao;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model m) {
        m.addAttribute("command", new User());
        m.addAttribute("profiles", profileDao.getProfiles());
        m.addAttribute("isTeacher", false);
        return "registeruser";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUserAsTeacher (@ModelAttribute("user") User user, BindingResult result, Model m) {
        System.out.println("Binding result" + result);
        System.out.println("Model" + m);
        User dbUser = userDao.getUserByEmail(user.getEmail());
        if (dbUser==null) {
            userDao.add(user);
            m.addAttribute("command", user);
            return "login";
        }
        dbUser.setEmail("");
        m.addAttribute("command", dbUser);
        m.addAttribute("error", "E-mail address is already taken.");
        return "registeruser";
    }
}
