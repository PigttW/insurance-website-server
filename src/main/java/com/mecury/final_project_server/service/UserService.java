package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.ProviderDetail;
import com.mecury.final_project_server.bean.User;
import com.mecury.final_project_server.bean.UserDetail;
import com.mecury.final_project_server.dao.ProviderDetailDao;
import com.mecury.final_project_server.dao.UserDao;
import com.mecury.final_project_server.dao.UserDetailDao;
import com.mecury.final_project_server.dao.UserProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailDao userDetailDao;

    @Autowired
    UserProfileDao userProfileDao;

    @Autowired
    ProviderDetailDao providerDetailDao;

    @Transactional
    public boolean addUser(User newUser) {
        User existingUser = userDao.findByUsername(newUser.getUsername());
        if (existingUser != null) {
            return false;
        } else {
            try {
                newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
                userDao.save(newUser);
                User addedUser = userDao.findByUsername(newUser.getUsername());
                UserDetail userDetail = new UserDetail();
                userDetail.setUser(addedUser);
                userDetailDao.save(userDetail);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Transactional
    public boolean addProvider(User newUser) {
        User existingUser = userDao.findByUsername(newUser.getUsername());
        if (existingUser != null) {
            return false;
        } else {
            try {
                newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
                userDao.save(newUser);
                User addedUser = userDao.findByUsername(newUser.getUsername());
                ProviderDetail providerDetail = new ProviderDetail();
                providerDetail.setUser(addedUser);
                providerDetail.setVerified(false);
                providerDetailDao.save(providerDetail);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.findByUsername(username);
    }


}
