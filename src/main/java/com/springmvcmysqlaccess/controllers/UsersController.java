package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.UserDao;
import com.springmvcmysqlaccess.models.User;
import com.springmvcmysqlaccess.security.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    UserDao dao;

    // ---> Get all
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<User> users = dao.getUsers();
        m.addAttribute("list", users);
        return "users";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String showAddUsers(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new User());
        return "adduser";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String adduser (@ModelAttribute("user") User user, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(user);
        return "redirect:/users";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.GET)
    public String showUpdateUser(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getUserById(id));
        return "updateuser";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(user);
        return "redirect:/users";
    }

    // ---> Delete
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/users";
    }
}
