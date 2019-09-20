package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.*;
import com.springmvcmysqlaccess.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@Controller
public class RegisterController {

    @Autowired
    StudentDao studentDao;

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProfileDao profileDao;

    @RequestMapping(value = "/registerstudent", method = RequestMethod.GET)
    public String showRegisterStudent(Model m) {
        RestTemplate restTemplate = new RestTemplate();
        Greeting quote = restTemplate.getForObject("http://localhost:8080/SpringMVCPagination_war_exploded/greeting", Greeting.class);
        System.out.println(quote.toString());
        m.addAttribute("command", new RegisterStudentViewModel());
        m.addAttribute("profiles", profileDao.getProfiles());
        m.addAttribute("courses", courseDao.getCourses());
        return "registerstudent";
    }

    @RequestMapping(value = "/registerstudent", method = RequestMethod.POST)
    public String registerStudent (@ModelAttribute("registerstudent") RegisterStudentViewModel viewModel, Model m) {
        User dbUser = userDao.getUserByEmail(viewModel.getEmail());

        if (dbUser==null) {
            User user = getUserFromViewModel(viewModel);
            int userId = ((BigInteger) userDao.add(user)).intValue();
            Student student = new Student();
            student.setUserid_fk(userId);
            student.setBirthdate(viewModel.getBirthdate());
            student.setCourseid_fk(viewModel.getCourseid_fk());
            studentDao.add(student);
            m.addAttribute("command", user);
            return "login";
        }

        viewModel.setEmail("");
        m.addAttribute("command", viewModel);
        m.addAttribute("profiles", profileDao.getProfiles());
        m.addAttribute("courses", courseDao.getCourses());
        m.addAttribute("error", "E-mail address is already taken.");
        return "registerstudent";
    }


    @RequestMapping(value = "/registerteacher", method = RequestMethod.GET)
    public String showRegisterTeacher(Model m) {
        m.addAttribute("command", new RegisterTeacherViewModel());
        m.addAttribute("profiles", profileDao.getProfiles());
        return "registerteacher";
    }

    @RequestMapping(value = "/registerteacher", method = RequestMethod.POST)
    public String registerTeacher (@ModelAttribute("registerteacher") RegisterTeacherViewModel viewModel, Model m) {
        User dbUser = userDao.getUserByEmail(viewModel.getEmail());

        if (dbUser==null) {
            User user = getUserFromViewModel(viewModel);
            int userId = ((BigInteger) userDao.add(user)).intValue();
            Teacher teacher = new Teacher();
            teacher.setUserid_fk(userId);
            teacher.setTitle(viewModel.getTitle());
            teacherDao.add(teacher);
            m.addAttribute("command", user);
            return "login";
        }

        viewModel.setEmail("");
        m.addAttribute("command", viewModel);
        m.addAttribute("profiles", profileDao.getProfiles());
        m.addAttribute("error", "E-mail address is already taken.");
        return "registerteacher";
    }

    private <T extends User> User getUserFromViewModel (T viewModel) {
        User user = new User ();
        user.setEnrollment(viewModel.getEnrollment());
        user.setName(viewModel.getName());
        user.setPassword(viewModel.getPassword());
        user.setEmail(viewModel.getEmail());
        user.setProfileid_fk(viewModel.getProfileid_fk());
        return user;
    }
}
