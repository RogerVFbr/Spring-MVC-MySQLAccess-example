package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.*;
import com.springmvcmysqlaccess.models.*;
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

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public String showSubject(Model m) {
//        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Subject> subjects = dao.getSubjects();
        m.addAttribute("list", subjects);
        return "subjects";
    }

//    @RequestMapping(value = "/addclass", method = RequestMethod.GET)
//    public String showAddClasses(Model m) {
//        if (!Auth.isLoggedIn()) return "redirect:/login";
//        m.addAttribute("command", new ClassMdl());
//        return "addclass";
//    }
//
//    @RequestMapping(value = "/addclass", method = RequestMethod.POST)
//    public String addClass (@ModelAttribute("class") ClassMdl classMdl, Model m) {
//        if (!Auth.isLoggedIn()) return "redirect:/login";
//        dao.add(classMdl);
//        return "redirect:/classes";
//    }
//
//    @RequestMapping(value = "/updateclass/{id}", method = RequestMethod.GET)
//    public String showUpdateClass(@PathVariable int id, Model m) {
//        if (!Auth.isLoggedIn()) return "redirect:/login";
//        ClassMdl classMdl = dao.getClassById(id);
//        m.addAttribute("command", classMdl);
//        return "updateclass";
//    }
//
//    @RequestMapping(value = "/updateclass", method = RequestMethod.POST)
//    public String updateClass(@ModelAttribute("class") ClassMdl classMdl, Model m) {
//        if (!Auth.isLoggedIn()) return "redirect:/login";
//        dao.update(classMdl);
//        return "redirect:/classes";
//    }
//
//    @RequestMapping(value = "/deleteclass/{id}", method = RequestMethod.GET)
//    public String deleteClass(@PathVariable int id) {
//        if (!Auth.isLoggedIn()) return "redirect:/login";
//        dao.delete(id);
//        return "redirect:/classes";
//    }
}