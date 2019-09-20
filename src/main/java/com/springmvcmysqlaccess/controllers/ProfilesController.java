package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.ProfileDao;
import com.springmvcmysqlaccess.models.Profile;
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
public class ProfilesController {

    @Autowired
    ProfileDao dao;

    // ---> Get all
    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String showProfiles(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Profile> profiles = dao.getProfiles();
        m.addAttribute("list", profiles);
        return "profiles";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addprofile", method = RequestMethod.GET)
    public String showAddProfiles(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new Profile());
        return "addprofile";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addprofile", method = RequestMethod.POST)
    public String addProfile (@ModelAttribute("profile") Profile profile, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(profile);
        return "redirect:/profiles";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updateprofile/{id}", method = RequestMethod.GET)
    public String showUpdateProfile(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getProfileById(id));
        return "updateprofile";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updateprofile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("profile") Profile profile, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(profile);
        return "redirect:/profiles";
    }

    // ---> Delete
    @RequestMapping(value = "/deleteprofile/{id}", method = RequestMethod.GET)
    public String deleteProfile(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/profiles";
    }
}
