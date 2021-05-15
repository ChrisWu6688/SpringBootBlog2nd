package com.niu.demo.repository;

import com.niu.demo.entity.Article;
import com.niu.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    List<Article> findByUser(User user);

    @Query(value = "select article from Article article where article.articleName like %:articleNameLike%")
    List<Article> findByArticleNameLike(@Param("articleNameLike") String articleNameLike);
}
