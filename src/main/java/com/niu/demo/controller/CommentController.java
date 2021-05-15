package com.niu.demo.controller;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.Comment;
import com.niu.demo.entity.User;
import com.niu.demo.service.ArticleService;
import com.niu.demo.service.CommentService;
import com.niu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private UserService userService;
    @Autowired
    private ArticleService articleService;

    @PostMapping("/addComment")
    public String addComment(Comment comment, int userId, int articleId, Model model) {
        User user = userService.findById(userId);
        Article article = articleService.findByArticleId(articleId);
        comment.setUser(user);
        comment.setArticle(article);
        commentService.addComment(comment);
        return"redirect:displayArticle?articleId=" + articleId;

    }


}