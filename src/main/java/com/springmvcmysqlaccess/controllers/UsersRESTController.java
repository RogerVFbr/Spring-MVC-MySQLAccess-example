package com.springmvcmysqlaccess.controllers;

import com.springmvcmysqlaccess.dao.UserDao;
import com.springmvcmysqlaccess.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersRESTController {

    @Autowired
    UserDao userDao;

    @GetMapping("/usersapi")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

}

