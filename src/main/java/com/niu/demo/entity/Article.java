package com.niu.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Article  {
    @Id
    @GeneratedValue
    private int articleId;

    private String articleName;

    @Transient
    private String articleTypeName;

    @Column(columnDefinition = "TEXT")
    private String articleContent;

    private String articleCreateDate;

    private String articleModifyDate;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private ArticleType articleType;

    @OneToMany(mappedBy = "article")
    private Set<Comment> comments = new HashSet<>();

    public Article() {

    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getArticleCreateDate() {
        return articleCreateDate;
    }

    public void setArticleCreateDate(String articleCreateDate) {
        this.articleCreateDate = articleCreateDate;
    }

    public String getArticleModifyDate() {
        return articleModifyDate;
    }

    public void setArticleModifyDate(String articleModifyDate) {
        this.articleModifyDate = articleModifyDate;
    }

    public String getArticleTypeName() {
        return articleTypeName;
    }

    public void setArticleTypeName(String articleTypeName) {
        this.articleTypeName = articleTypeName;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }

    public Set<Comment> getComments() {
        return comments;
    }


    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
