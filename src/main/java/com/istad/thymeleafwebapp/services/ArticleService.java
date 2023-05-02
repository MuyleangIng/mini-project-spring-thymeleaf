package com.istad.thymeleafwebapp.services;

import com.istad.thymeleafwebapp.models.Article;
import com.istad.thymeleafwebapp.models.Author;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleService {
    // find all article
    // POJO
    List<Article> findAll();

    List<Author> auths();
    Article singleArticle(String uuid);

    boolean save(Article article, MultipartFile file);

    List<Article> getArticleByAuthor(Author author);

}
