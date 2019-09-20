package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.CourseDao;
import com.springmvcmysqlaccess.models.Course;
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
public class CoursesController {

    @Autowired
    CourseDao dao;

    // ---> Get all
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public String showCourses(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        List<Course> courses = dao.getCourses();
        m.addAttribute("list", courses);
        return "courses";
    }

    // ---> Add (GET)
    @RequestMapping(value = "/addcourse", method = RequestMethod.GET)
    public String showAddCourses(Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", new Course());
        return "addcourse";
    }

    // ---> Add (POST)
    @RequestMapping(value = "/addcourse", method = RequestMethod.POST)
    public String addCourse (@ModelAttribute("course") Course course, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.add(course);
        return "redirect:/courses";
    }

    // ---> Update (GET)
    @RequestMapping(value = "/updatecourse/{id}", method = RequestMethod.GET)
    public String showUpdateCourse(@PathVariable int id, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        m.addAttribute("command", dao.getCourseById(id));
        return "updatecourse";
    }

    // ---> Update (POST)
    @RequestMapping(value = "/updatecourse", method = RequestMethod.POST)
    public String updateCourse(@ModelAttribute("course") Course course, Model m) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.update(course);
        return "redirect:/courses";
    }

    // ---> Delete
    @RequestMapping(value = "/deletecourse/{id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable int id) {
        if (!Auth.isLoggedIn()) return "redirect:/login";
        dao.delete(id);
        return "redirect:/courses";
    }
}
