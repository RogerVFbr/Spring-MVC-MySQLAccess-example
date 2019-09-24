package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.config.Res;
import com.springmvcmysqlaccess.dao.*;
import com.springmvcmysqlaccess.models.StudentUserViewModel;
import com.springmvcmysqlaccess.models.TeacherUserViewModel;
import com.springmvcmysqlaccess.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ProfileDao profileDao;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/register/{type}", method = RequestMethod.GET)
    public String showRegisterByType(@PathVariable String type, Model m) {
        if (type.equals("student")) {
            m.addAttribute("command", new StudentUserViewModel());
            m.addAttribute("profiles", profileDao.getProfiles());
            m.addAttribute("courses", courseDao.getCourses());
            return "registerstudent";
        }
        else {
            m.addAttribute("command", new TeacherUserViewModel());
            m.addAttribute("profiles", profileDao.getProfiles());
            return "registerteacher";
        }
    }

    @RequestMapping(value = "/registerstudent", method = RequestMethod.POST)
    public String registerStudent (@ModelAttribute("registerstudent") StudentUserViewModel viewModel, Model m) {

        List response = restTemplate.postForObject(Res.API_BASE_ENDPOINT + "/registerstudentapi", viewModel,
                List.class);

        if (response.isEmpty()) {
            m.addAttribute("command", getUserDataFromViewModel(viewModel));
            return "login";
        }

        updateModel(viewModel, response, m);
        m.addAttribute("courses", courseDao.getCourses());
        return "registerstudent";
    }

    @RequestMapping(value = "/registerteacher", method = RequestMethod.POST)
    public String registerTeacher (@ModelAttribute("registerteacher") TeacherUserViewModel viewModel, Model m) {

        List response = restTemplate.postForObject(Res.API_BASE_ENDPOINT + "/registerteacherapi", viewModel,
                List.class);

        if (response.isEmpty()) {
            m.addAttribute("command", getUserDataFromViewModel(viewModel));
            return "login";
        }

        updateModel(viewModel, response, m);
        return "registerteacher";
    }

    private <T extends User> User getUserDataFromViewModel (T viewModel) {
        User user = new User();
        user.setEmail(viewModel.getEmail());
        user.setPassword(viewModel.getPassword());
        return user;
    }

    private <T> void updateModel(T viewModel, List response, Model m) {
        m.addAttribute("command", viewModel);
        m.addAttribute("profiles", profileDao.getProfiles());
        m.addAttribute("errors", response);
    }
}
