
package com.literalura.controller;

import com.literalura.model.Book;           // Import del modelo Book
import com.literalura.service.BookService;  // Import del servicio BookService
import org.springframework.beans.factory.annotation.Autowired;  // Autowired para la inyección de dependencias
import org.springframework.web.bind.annotation.*;  // Anotaciones para controlador REST
import java.util.List;  // Para manejar listas de libros

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/language/{language}")
    public List<Book> getBooksByLanguage(@PathVariable String language) {
        return bookService.listBooksByLanguage(language);
    }

    @GetMapping("/author/{author}")
    public List<Book> getBooksByAuthor(@PathVariable String author) {
        return bookService.listBooksByAuthor(author);
    }
}
