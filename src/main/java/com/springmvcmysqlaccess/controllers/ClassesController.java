package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.ClassMdlDao;
import com.springmvcmysqlaccess.models.ClassMdl;
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
public class ClassesController {

    @Autowired
    ClassMdlDao dao;

    // ---> Get all
    @RequestMapping(value = "/classes", method = RequestMethod.GET)
    public String showClass(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<ClassMdl> Classs = dao.getClasses();
        m.addAttribute("list", Classs);
        return "classes";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addclass", method = RequestMethod.GET)
    public String showAddClass(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new ClassMdl());
        return "addclass";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
    public String addClass (@ModelAttribute("class") ClassMdl classMdl, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(classMdl);
        return "redirect:/classes";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updateclass/{id}", method = RequestMethod.GET)
    public String showUpdateClass(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getClassById(id));
        return "updateclass";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updateclass", method = RequestMethod.POST)
    public String updateClass(@ModelAttribute("class") ClassMdl classMdl, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(classMdl);
        return "redirect:/classes";
    }

    // ---> Delete
    @RequestMapping(value = "/deleteclass/{id}", method = RequestMethod.GET)
    public String deleteClass(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/classes";
    }
}
