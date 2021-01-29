package com.mecury.final_project_server.dao;

import com.mecury.final_project_server.bean.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileDao extends JpaRepository<UserProfile, Long> {

    UserProfile findByType(String type);
}
