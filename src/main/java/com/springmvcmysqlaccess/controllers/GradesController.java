package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.GradeDao;
import com.springmvcmysqlaccess.models.Grade;
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
public class GradesController {

    @Autowired
    GradeDao dao;

    // ---> Get all
    @RequestMapping(value = "/grades", method = RequestMethod.GET)
    public String showGrades(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Grade> grades = dao.getGrades();
        m.addAttribute("list", grades);
        return "grades";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addgrade", method = RequestMethod.GET)
    public String showAddGrades(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new Grade());
        return "addgrade";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addgrade", method = RequestMethod.POST)
    public String addGrade (@ModelAttribute("grade") Grade grade, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(grade);
        return "redirect:/grades";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updategrade/{id}", method = RequestMethod.GET)
    public String showUpdategrade(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getGradeById(id));
        return "updategrade";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updategrade", method = RequestMethod.POST)
    public String updategrade(@ModelAttribute("grade") Grade grade, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(grade);
        return "redirect:/grades";
    }

    // ---> Delete
    @RequestMapping(value = "/deletegrade/{id}", method = RequestMethod.GET)
    public String deletegrade(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/grades";
    }
}
