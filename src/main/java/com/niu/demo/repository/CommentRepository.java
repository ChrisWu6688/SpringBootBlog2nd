package com.niu.demo.repository;

import com.niu.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByArticle(Article article);

    Comment findByCommentId(int commentId);
}
