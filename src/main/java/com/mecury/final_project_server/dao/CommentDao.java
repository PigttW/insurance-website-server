package com.mecury.final_project_server.dao;

import com.mecury.final_project_server.bean.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Long> {
}
