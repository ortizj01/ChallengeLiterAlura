package com.literalura.service;

import com.literalura.model.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ExternalBookService {

    public Book searchBookByTitle(String title) {
        String apiUrl = "https://gutendex.com/books?title=" + title;
        RestTemplate restTemplate = new RestTemplate();
        ApiResponse apiResponse = restTemplate.getForObject(apiUrl, ApiResponse.class);

        if (apiResponse != null && !apiResponse.getResults().isEmpty()) {
            ApiBook apiBook = apiResponse.getResults().get(0);
            List<Author> authors = apiBook.getAuthors().stream()
                    .map(apiPerson -> new Author(apiPerson.getName(), apiPerson.getBirth_year(), apiPerson.getDeath_year()))
                    .collect(Collectors.toList());

            return new Book(
                    apiBook.getTitle(),
                    apiBook.getLanguages().isEmpty() ? "Unknown" : apiBook.getLanguages().get(0),
                    apiBook.getDownload_count(),
                    apiBook.getSubjects(),
                    apiBook.getBookshelves(),
                    authors
            );
        }
        return null;
    }
}
