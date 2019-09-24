package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.StudentDao;
import com.springmvcmysqlaccess.dao.StudentUserDao;
import com.springmvcmysqlaccess.dao.TeacherDao;
import com.springmvcmysqlaccess.dao.UserDao;
import com.springmvcmysqlaccess.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@RestController
public class RegisterRESTController {

    @Autowired
    UserDao userDao;

    @Autowired
    StudentDao studentDao;

    @Autowired
    StudentUserDao studentUserDao;

    @Autowired
    TeacherDao teacherDao;

    @PostMapping("/registerstudentapi")
    public List<String> registerStudent(@RequestBody StudentUserViewModel viewModel) {

        List<String> response = new ArrayList();

        User userByEmail = userDao.getUserByEmail(viewModel.getEmail());
        User userByEnrollment = userDao.getUserByEnrollment(viewModel.getEnrollment());
        if (userByEmail != null) response.add("This e-mail address has already been taken.");
        if (userByEnrollment != null) response.add("This enrollment number has already been taken.");
        if (response.size() != 0) return response;

//        studentUserDao.add(viewModel);

        User user = getUserFromViewModel(viewModel);
        int userId = ((BigInteger) userDao.add(user)).intValue();
        Student student = new Student();
        student.setUserid_fk(userId);
        student.setBirthdate(viewModel.getBirthdate());
        student.setCourseid_fk(viewModel.getCourseid_fk());
        studentDao.add(student);
        return response;
    }

    @PostMapping("/registerteacherapi")
    public List<String> registerTeacher(@RequestBody TeacherUserViewModel viewModel) {

        List<String> response = new ArrayList();

        User userByEmail = userDao.getUserByEmail(viewModel.getEmail());
        if (userByEmail != null) response.add("This e-mail address has already been taken.");
        if (response.size() != 0) return response;

        User user = getUserFromViewModel(viewModel);
        int userId = ((BigInteger) userDao.add(user)).intValue();
        Teacher teacher = new Teacher();
        teacher.setUserid_fk(userId);
        teacher.setTitle(viewModel.getTitle());
        teacherDao.add(teacher);
        return response;
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
