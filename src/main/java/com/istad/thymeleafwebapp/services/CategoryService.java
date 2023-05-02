package com.istad.thymeleafwebapp.services;

import com.istad.thymeleafwebapp.models.Category;
import com.istad.thymeleafwebapp.models.CategoryArticles;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    CategoryArticles getCategoryById(Integer id);
}
