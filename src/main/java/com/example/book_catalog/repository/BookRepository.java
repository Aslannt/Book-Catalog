// src/main/java/com/example/book_catalog/repository/BookRepository.java
package com.example.book_catalog.repository;

import com.example.book_catalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsByTitle(String title);
}
