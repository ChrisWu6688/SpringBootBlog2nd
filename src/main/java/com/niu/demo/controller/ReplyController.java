package com.niu.demo.controller;

import com.niu.demo.entity.Comment;
import com.niu.demo.entity.Reply;
import com.niu.demo.entity.User;
import com.niu.demo.service.CommentService;
import com.niu.demo.service.ReplyService;
import com.niu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReplyController {
    @Autowired
    private ReplyService replyService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;

    @PostMapping("/addReply")
    public String addReply(Reply reply, int userId, int commentId, int articleId, Model model) {
        User user = userService.findById(userId);
        Comment comment = commentService.findByCommentId(commentId);
        reply.setUser(user);
        reply.setComment(comment);
        replyService.addReply(reply);
        return "redirect:displayArticle?articleId=" + articleId;

    }
}