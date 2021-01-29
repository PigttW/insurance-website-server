package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.User;
import com.mecury.final_project_server.bean.UserDetail;
import com.mecury.final_project_server.dao.UserDao;
import com.mecury.final_project_server.dao.UserDetailDao;
import com.mecury.final_project_server.http.AuthenticationSuccessResponse;
import com.mecury.final_project_server.http.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserDao userDao;
    @Autowired
    UserDetailDao userDetailDao;

    public UserDetail getCurrentUserDetail(Authentication authentication) {
        if (authentication != null) {
            User user = userDao.findByUsername(authentication.getName());
            UserDetail userDetail = userDetailDao.findById(user.getId()).orElse(new UserDetail());
            return userDetail;
        } else {
            return new UserDetail();
        }
    }

    public Response checklogin(Authentication authentication) {
        if (authentication != null) {
            Response response = new AuthenticationSuccessResponse(true, 200, "Logged In!", userDao.findByUsername(authentication.getName()));
            return response;
        } else {
            return new Response(false);
        }

    }
}
