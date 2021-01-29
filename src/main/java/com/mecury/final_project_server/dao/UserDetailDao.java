package com.mecury.final_project_server.dao;

import com.mecury.final_project_server.bean.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDetailDao extends JpaRepository<UserDetail, Long> {

    UserDetail findByUserId(long id);
}
