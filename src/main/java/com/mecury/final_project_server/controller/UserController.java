package com.mecury.final_project_server.controller;


import com.mecury.final_project_server.bean.User;
import com.mecury.final_project_server.dao.UserDao;
import com.mecury.final_project_server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @PostMapping
    public boolean postUsers(@RequestBody User user) {
        return userService.addUser(user);
    }

}
