// src/main/java/com/example/book_catalog/service/AuthorService.java
package com.example.book_catalog.service;

import com.example.book_catalog.model.Author;
import com.example.book_catalog.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAll().stream()
                .filter(author -> isAuthorAliveInYear(author, year))
                .collect(Collectors.toList());
    }

    private boolean isAuthorAliveInYear(Author author, int year) {
        int birthYear = Integer.parseInt(author.getBirthDate().split("-")[0]);
        int deathYear = author.getDeathDate() == null ? Integer.MAX_VALUE : Integer.parseInt(author.getDeathDate().split("-")[0]);
        return year >= birthYear && year <= deathYear;
    }
}
