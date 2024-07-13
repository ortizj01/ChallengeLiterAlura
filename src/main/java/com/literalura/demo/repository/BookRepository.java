package com.literalura.service;

import com.literalura.model.Author;
import com.literalura.model.Book;
import com.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
        return bookRepository.findAll().stream()
                .flatMap(book -> book.getAuthors().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Author> listAuthorsAliveInYear(int year) {
        return bookRepository.findAll().stream()
                .flatMap(book -> book.getAuthors().stream())
                .filter(author -> (author.getBirthYear() != null && author.getBirthYear() <= year) &&
                        (author.getDeathYear() == null || author.getDeathYear() >= year))
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Book> listBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public boolean isBookExists(Book book) {
        return bookRepository.findByTitle(book.getTitle()).isPresent();
    }
}
