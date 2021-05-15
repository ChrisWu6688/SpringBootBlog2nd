package com.niu.demo.repository;

import com.niu.demo.entity.ArticleType;

import com.niu.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTypeRepository extends JpaRepository<ArticleType, Integer> {
    List<ArticleType> findByUser(User user);

    ArticleType findByArticleTypeNameAndUser(String articleTypeName, User user);

    ArticleType findByArticleTypeId(int articleTypeId);
}
