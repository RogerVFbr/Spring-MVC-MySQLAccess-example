package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.TeacherDao;
import com.springmvcmysqlaccess.models.Teacher;
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
public class TeachersController {

    @Autowired
    TeacherDao dao;

    // ---> Get all
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String showTeachers(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Teacher> teachers = dao.getTeachers();
        m.addAttribute("list", teachers);
        return "teachers";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addteacher", method = RequestMethod.GET)
    public String showAddTeachers(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new Teacher());
        return "addteacher";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addteacher", method = RequestMethod.POST)
    public String addTeacher (@ModelAttribute("teacher") Teacher teacher, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(teacher);
        return "redirect:/teachers";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updateteacher/{id}", method = RequestMethod.GET)
    public String showUpdateTeacher(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getTeacherById(id));
        return "updateteacher";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updateteacher", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute("teacher") Teacher teacher, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(teacher);
        return "redirect:/teachers";
    }

    // ---> Delete
    @RequestMapping(value = "/deleteteacher/{id}", method = RequestMethod.GET)
    public String deleteTeacher(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/teachers";
    }
}
