package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.*;
import com.springmvcmysqlaccess.models.Student;
import com.springmvcmysqlaccess.models.StudentUserViewModel;
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
public class StudentsController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentUserDao studentUserDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProfileDao profileDao;

    // ---> Get all
    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String showStudents(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Student> students = studentDao.getStudents();
        m.addAttribute("list", students);
        return "students";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addstudent", method = RequestMethod.GET)
    public String showAddStudents(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new Student());
        return "addstudent";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public String addStudent (@ModelAttribute("student") Student student, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        studentDao.add(student);
        return "redirect:/students";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updatestudent/{id}", method = RequestMethod.GET)
    public String showUpdateStudent(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", studentUserDao.getStudentUserById(id));
        m.addAttribute("profiles", profileDao.getProfiles());
        m.addAttribute("courses", courseDao.getCourses());
        return "updatestudent";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updatestudent", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("student") StudentUserViewModel studentUser, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";

        studentDao.update(student);
        return "redirect:/users";
    }

    // ---> Delete
    @RequestMapping(value = "/deletestudent/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        studentDao.delete(id);
        return "redirect:/students";
    }
}
