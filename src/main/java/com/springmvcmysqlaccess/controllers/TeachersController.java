package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.ProfileDao;
import com.springmvcmysqlaccess.dao.TeacherDao;
import com.springmvcmysqlaccess.dao.TeacherUserDao;
import com.springmvcmysqlaccess.models.Teacher;
import com.springmvcmysqlaccess.models.TeacherUserViewModel;
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
    TeacherDao teacherDao;

    @Autowired
    TeacherUserDao teacherUserDao;

    @Autowired
    ProfileDao profileDao;

    // ---> Get all
    @RequestMapping(value = "/teachers", method = RequestMethod.GET)
    public String showTeachers(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Teacher> teachers = teacherDao.getTeachers();
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
        teacherDao.add(teacher);
        return "redirect:/teachers";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updateteacher/{id}", method = RequestMethod.GET)
    public String showUpdateTeacher(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", teacherUserDao.getTeacherUserById(id));
        m.addAttribute("profiles", profileDao.getProfiles());
        return "updateteacher";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updateteacher", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute("teacher") TeacherUserViewModel teacherUser, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        teacherUserDao.update(teacherUser);
        return "redirect:/users";
    }

    // ---> Delete
    @RequestMapping(value = "/deleteteacher/{id}", method = RequestMethod.GET)
    public String deleteTeacher(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        teacherUserDao.delete(id);
        return "redirect:/users";
    }
}
