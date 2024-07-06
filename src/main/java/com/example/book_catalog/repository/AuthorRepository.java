// src/main/java/com/example/book_catalog/repository/AuthorRepository.java
package com.example.book_catalog.repository;

import com.example.book_catalog.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
