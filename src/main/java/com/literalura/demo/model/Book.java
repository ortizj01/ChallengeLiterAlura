package com.literAlura.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String language;
    private int downloadCount;

    @ElementCollection
    private List<String> subjects;

    @ElementCollection
    private List<String> bookshelves;

    @ElementCollection
    private List<Author> authors;

    public Book() {
    }

    public Book(String title, String language, int downloadCount, List<String> subjects, List<String> bookshelves, List<Author> authors) {
        this.title = title;
        this.language = language;
        this.downloadCount = downloadCount;
        this.subjects = subjects;
        this.bookshelves = bookshelves;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public List<String> getBookshelves() {
        return bookshelves;
    }

    public void setBookshelves(List<String> bookshelves) {
        this.bookshelves = bookshelves;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return downloadCount == book.downloadCount && Objects.equals(id, book.id) && Objects.equals(title, book.title) && Objects.equals(language, book.language) && Objects.equals(subjects, book.subjects) && Objects.equals(bookshelves, book.bookshelves) && Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, language, downloadCount, subjects, bookshelves, authors);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", downloadCount=" + downloadCount +
                ", subjects=" + subjects +
                ", bookshelves=" + bookshelves +
                ", authors=" + authors +
                '}';
    }
}
