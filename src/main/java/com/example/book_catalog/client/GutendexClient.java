// src/main/java/com/example/book_catalog/client/GutendexClient.java
package com.example.book_catalog.client;

import com.example.book_catalog.model.Book;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GutendexClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://gutendex.com/books?search=";

    public Book searchBookByTitle(String title) {
        String url = API_URL + title;
        // Lógica para consumir la API Gutendex y mapear la respuesta a un objeto Book
        // Aquí agregaremos la lógica de búsqueda de libros
        return null; // Implementar la lógica para devolver el libro encontrado
    }
}
