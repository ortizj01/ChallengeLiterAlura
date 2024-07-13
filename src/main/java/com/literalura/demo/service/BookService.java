
package com.literalura.service;

import com.literalura.model.Book;         // Import del modelo Book
import com.literalura.model.Author;       // Import del modelo Author
import com.literalura.repository.BookRepository;  // Import del repositorio BookRepository
import org.springframework.beans.factory.annotation.Autowired;  // Autowired para la inyección de dependencias
import org.springframework.stereotype.Service;  // Anotación para marcar la clase como un servicio

import java.util.List;  // Para manejar listas de libros y autores

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> listAuthors() {
        // Implementación para listar autores únicos
    }

    public List<Author> listAuthorsAliveInYear(int year) {
        // Implementación para listar autores vivos en un año determinado
    }

    public List<Book> listBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public boolean isBookExists(Book book) {
        return bookRepository.findByTitle(book.getTitle()).isPresent();
    }
}
