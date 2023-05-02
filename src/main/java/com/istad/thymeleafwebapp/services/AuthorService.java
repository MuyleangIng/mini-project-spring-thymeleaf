package com.istad.thymeleafwebapp.services;

import com.istad.thymeleafwebapp.models.Author;

import java.util.List;

public interface AuthorService {
    List<Author> getAuthors();

    Author getAuthorById(Integer id);
}
