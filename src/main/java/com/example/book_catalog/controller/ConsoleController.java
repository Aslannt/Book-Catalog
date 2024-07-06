// src/main/java/com/example/book_catalog/controller/ConsoleController.java
package com.example.book_catalog.controller;

import com.example.book_catalog.client.GutendexClient;
import com.example.book_catalog.model.Book;
import com.example.book_catalog.service.BookService;
import com.example.book_catalog.service.AuthorService;
import com.example.book_catalog.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleController implements CommandLineRunner {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private GutendexClient gutendexClient;

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Search Book by Title");
            System.out.println("2. List Registered Books");
            System.out.println("3. List Registered Authors");
            System.out.println("4. List Authors Alive in Specific Year");
            System.out.println("5. List Books by Language");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    String title = scanner.nextLine();
                    Book book = gutendexClient.searchBookByTitle(title);
                    if (book != null) {
                        bookService.addBook(book);
                        System.out.println("Book added successfully");
                    } else {
                        System.out.println("Book not found");
                    }
                    break;
                case 2:
                    bookService.getAllBooks().forEach(System.out::println);
                    break;
                case 3:
                    authorService.getAllAuthors().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    List<Author> authorsAliveInYear = authorService.getAuthorsAliveInYear(year);
                    authorsAliveInYear.forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Enter language:");
                    String language = scanner.nextLine();
                    List<Book> booksByLanguage = bookService.getBooksByLanguage(language);
                    booksByLanguage.forEach(System.out::println);
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
