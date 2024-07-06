// src/main/java/com/example/book_catalog/service/BookService.java
package com.example.book_catalog.service;

import com.example.book_catalog.model.Book;
import com.example.book_catalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        if (!bookRepository.existsByTitle(book.getTitle())) {
            bookRepository.save(book);
        } else {
            throw new RuntimeException("Book already exists");
        }
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findAll().stream()
                .filter(book -> book.getLanguage().equalsIgnoreCase(language))
                .collect(Collectors.toList());
    }
}
