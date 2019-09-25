package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.*;
import com.springmvcmysqlaccess.models.Student;
import com.springmvcmysqlaccess.models.Teacher;
import com.springmvcmysqlaccess.models.User;
import com.springmvcmysqlaccess.security.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

    @Autowired
    UserDao userDao;

    @Autowired
    ProfileDao profileDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentUserDao studentUserDao;

    @Autowired
    TeacherUserDao teacherUserDao;

    // ---> Get all
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String showUsers(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("studentUser", studentUserDao.getStudentUsers());
        m.addAttribute("teacherUser", teacherUserDao.getTeacherUsers());
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
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String adduser (@ModelAttribute("user") User user, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        userDao.add(user);
        return "redirect:/users";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updateuser/{id}", method = RequestMethod.GET)
    public String showUpdateUser(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", userDao.getUserById(id));
        m.addAttribute("profiles", profileDao.getProfiles());
        return "updatestudent";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("user") User user, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        userDao.update(user);
        return "redirect:/users";
    }

    // ---> Delete
    @RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        Teacher teacher = teacherDao.getTeacherByUserId(id);
        if (teacher == null) {
            Student student = studentDao.getStudentByUserId(id);
            if (student != null) {
                studentDao.delete(student.getStudentid());
            }
        }
        else {
            System.out.println("teacher not null");
            teacherDao.delete(teacher.getTeacherid());
        }
        userDao.delete(id);
        return "redirect:/users";
    }
}
