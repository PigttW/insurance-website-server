package com.mecury.final_project_server.service;

import com.mecury.final_project_server.bean.Comment;
import com.mecury.final_project_server.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDao commentDao;

    public List<Comment> getComments() {
        return commentDao.findAll();
    }

    @Transactional
    public boolean addComment(Comment comment) {
        try {
            commentDao.save(comment);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
