package com.mecury.final_project_server.controller;

import com.mecury.final_project_server.bean.Comment;
import com.mecury.final_project_server.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @PostMapping
    public boolean addComment(@RequestBody Comment comment) {
        return commentService.addComment(comment);
    }
}
