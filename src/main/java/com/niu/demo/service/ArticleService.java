package com.niu.demo.service;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.ArticleType;
import com.niu.demo.entity.User;
import com.niu.demo.repository.ArticleRepository;
import com.niu.demo.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    public Article add(Article article) {
        article.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return articleRepository.save(article);
    }

    public List<Article> list() {
        return articleRepository.findByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public void deleteByArticleId(int articleId) {
        articleRepository.deleteById(articleId);
    }

    public Article findByArticleId(int articleId) {
        return articleRepository.findByArticleId(articleId);
    }

    public Article modify(int articleId, String articleName, String articleTypeName, String articleModifyDate, String articleContent) {
        Article article = articleRepository.findByArticleId(articleId);
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        ArticleType articleType = articleTypeRepository.findByArticleTypeNameAndUser(articleTypeName, user);
        article.setArticleName(articleName);
        article.setArticleType(articleType);
        article.setArticleModifyDate(articleModifyDate);
        article.setArticleContent(articleContent);
        articleRepository.save(article);
        return article;
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public List<Article> findByArticleNameLike(String articleNameLike) {
        return articleRepository.findByArticleNameLike(articleNameLike);
    }
}
