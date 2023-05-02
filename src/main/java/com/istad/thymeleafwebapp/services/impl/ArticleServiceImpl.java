package com.istad.thymeleafwebapp.services.impl;

import com.istad.thymeleafwebapp.models.Article;
import com.istad.thymeleafwebapp.models.Author;
import com.istad.thymeleafwebapp.models.FileUpload;
import com.istad.thymeleafwebapp.repositories.StaticRepository;
import com.istad.thymeleafwebapp.services.ArticleService;
import com.istad.thymeleafwebapp.services.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private final StaticRepository staticRepository;
    private final FileUploadService fileUploadService;
    @Override
    public List<Article> findAll() {
        return staticRepository.getArticles();
    }

    @Override
    public List<Author> auths() {
        return staticRepository.getAuthors();
    }

    @Override
    public Article singleArticle(String uuid){
        Article article =  staticRepository.getArticles().stream()
                .filter(a -> a.getUuid().toString().equals(uuid))
                .findFirst()
                 .orElse(null);
        return article;
    }

    @Override
    public boolean save(Article article, MultipartFile file) {
        FileUpload fileUpload = fileUploadService.uploadSingle(file);
        if (fileUpload.isSuccess()){
            article.setUuid(UUID.randomUUID());
            article.setThumbnail("/files/" + fileUpload.fileName());
            staticRepository.getArticles().add(0,article);
        }
        return false;
    }

    @Override
    public List<Article> getArticleByAuthor(Author author) {
        return staticRepository.getArticles().stream()
                .filter(article -> article.getAuthor().equals(author))
                .toList();
    }

}
