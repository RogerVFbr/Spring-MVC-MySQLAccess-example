package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.SubjectDao;
import com.springmvcmysqlaccess.models.Subject;
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
public class SubjectController {

    @Autowired
    SubjectDao dao;

    // ---> Get all
    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public String showSubjects(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Subject> subjects = dao.getSubjects();
        m.addAttribute("list", subjects);
        return "subjects";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addsubject", method = RequestMethod.GET)
    public String showAddSubjects(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new Subject());
        return "addsubject";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addsubject", method = RequestMethod.POST)
    public String addSubject (@ModelAttribute("subject") Subject subject, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(subject);
        return "redirect:/subjects";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updatesubject/{id}", method = RequestMethod.GET)
    public String showUpdateSubject(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getSubjectById(id));
        return "updatesubject";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updatesubject", method = RequestMethod.POST)
    public String updateSubject(@ModelAttribute("subject") Subject subject, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(subject);
        return "redirect:/subjects";
    }

    // ---> Delete
    @RequestMapping(value = "/deletesubject/{id}", method = RequestMethod.GET)
    public String deleteSubject(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/subjects";
    }
}
