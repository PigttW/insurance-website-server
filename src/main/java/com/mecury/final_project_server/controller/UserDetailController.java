package com.mecury.final_project_server.controller;

import com.mecury.final_project_server.bean.ProviderDetail;
import com.mecury.final_project_server.bean.UserDetail;
import com.mecury.final_project_server.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/user-detail")
public class UserDetailController {

    @Autowired
    UserDetailService userDetailService;

    @GetMapping("/{id}")
    public UserDetail getUserDetailById(@PathVariable(name = "id") long id) {
        return userDetailService.getUserDetailById(id);
    }

    @PutMapping("/{id}")
    public boolean updateUserDetail(@PathVariable(name = "id") long id, @RequestBody UserDetail userDetail) {
        return userDetailService.updateUserDetail(id, userDetail);
    }
}
