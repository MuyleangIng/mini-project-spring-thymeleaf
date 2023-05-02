package com.istad.thymeleafwebapp.services.impl;

import com.istad.thymeleafwebapp.models.Article;
import com.istad.thymeleafwebapp.models.Category;
import com.istad.thymeleafwebapp.models.CategoryArticles;
import com.istad.thymeleafwebapp.repositories.StaticRepository;
import com.istad.thymeleafwebapp.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final StaticRepository staticRepository;

    @Override
    public List<Category> getCategories() {
        return staticRepository.getCategories();
    }

    @Override
    public CategoryArticles getCategoryById(Integer id) {
        Category category = staticRepository.getCategories().stream().filter(cat -> cat.getId().equals(id))
                            .findFirst().orElse(null);
        List<Article> articles = staticRepository.getArticles().stream()
                .filter(article -> article.getCategories().contains(category))
                .toList();
        return new CategoryArticles(category,articles);
    }
}
