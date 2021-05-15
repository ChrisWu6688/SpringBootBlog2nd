package com.niu.demo.service;

import com.niu.demo.entity.ArticleType;
import com.niu.demo.entity.User;
import com.niu.demo.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTypeService {

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    public ArticleType add(ArticleType articleType) {
        articleType.setUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return articleTypeRepository.save(articleType);
    }

    public List<ArticleType> list() {
        return articleTypeRepository.findByUser((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public void deleteByArticleTypeId(int articleTypeId) {
        articleTypeRepository.deleteById(articleTypeId);
    }

    public ArticleType findByArticleTypeId(int articleTypeId) {

    return articleTypeRepository.findByArticleTypeId(articleTypeId);
    }

    public ArticleType modify(int articleTypeId, String articleTypeName, String articleTypeStatus) {
        ArticleType articleType = articleTypeRepository.findById(articleTypeId).get();
        articleType.setArticleTypeName(articleTypeName);
        articleType.setArticleTypeStatus(articleTypeStatus);
        articleTypeRepository.save(articleType);
        return articleType;
    }
}
