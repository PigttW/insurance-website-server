package com.mecury.final_project_server.controller;

import com.mecury.final_project_server.bean.UserDetail;
import com.mecury.final_project_server.http.Response;
import com.mecury.final_project_server.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/current-user-detail")
    public UserDetail getCurrentUserDetail(Authentication authentication) {
        return authService.getCurrentUserDetail(authentication);
    }

    @GetMapping("/checklogin")
    public Response checklogin(Authentication authentication) {
        return authService.checklogin(authentication);
    }

}
