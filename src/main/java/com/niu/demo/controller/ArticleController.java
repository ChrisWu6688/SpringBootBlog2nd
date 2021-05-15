package com.niu.demo.controller;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.ArticleType;
import com.niu.demo.service.ArticleService;
import com.niu.demo.service.ArticleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleTypeService articleTypeService;

    @GetMapping("/addArticle")
    public String addArticle(Model model) {
        List<ArticleType> articleTypeList = articleTypeService.list();
        model.addAttribute(articleTypeList);
        return "addArticle";
    }

    @PostMapping("/addArticle")
    @ResponseBody
    public Article addArticle(Article article) {
        articleService.add(article);
        return article;
    }

    @GetMapping("/getArticles")
    public String getArticles(Model model) {
        List<Article> articleList = articleService.list();
        model.addAttribute("articleList", articleList);
        return "/getArticles";
    }

    @GetMapping("/getAllArticles")
    public String getAllArticles(Model model) {
        List<Article> articleList = articleService.findAll();
        model.addAttribute("articleList", articleList);
        return "/getAllArticles";
    }

    @GetMapping("/getArticlesJson")
    @ResponseBody
    public List<Article> getArticlesJson() {
        return articleService.list();
    }

    @GetMapping("/deleteArticle")
    public String deleteArticleType(Model model, @RequestParam("articleId") int articleId) {
        articleService.deleteByArticleId(articleId);
        List<Article> articleList = articleService.list();
        model.addAttribute("articleList", articleList);
        return "/getArticles";
    }

    @GetMapping("/modifyArticle")
    public String modifyArticle(Model model, @RequestParam("articleId") int articleId) {
        Article article = articleService.findByArticleId(articleId);
        List<ArticleType> articleTypeList = articleTypeService.list();
        model.addAttribute(article);
        model.addAttribute(articleTypeList);
        return "/modifyArticle";
    }


    @PostMapping("/modifyArticle")
    @ResponseBody
    public Article modifyArticle(int articleId, String articleName, String articleTypeName, String modifyDate, String articleContent) {
        return articleService.modify(articleId, articleName, articleTypeName, modifyDate, articleContent);
    }

    @GetMapping("/displayArticle")
    public String displayArticle(Model model, @RequestParam("articleId") int articleId) {
        Article article = articleService.findByArticleId(articleId);
        model.addAttribute("article", article);
        return "/displayArticle";
    }

    @GetMapping("/searchArticle")
    public String searchArticle() {
        return "searchArticle";
    }

    @PostMapping("/searchArticle")
    public String searchArticle(Model model, String articleNameLike) {
        List<Article> articleList = articleService.findByArticleNameLike(articleNameLike);
        model.addAttribute(articleList);
        return "searchArticle";
    }

    @GetMapping("/getArticlesByUser")
    public String getArticlesByUser(Model model, @RequestParam("userId") int userId) {
        List<Article> articleList = articleService.findByUserId(userId);
        model.addAttribute(articleList);
        return "/getArticlesByUser";
    }




}
