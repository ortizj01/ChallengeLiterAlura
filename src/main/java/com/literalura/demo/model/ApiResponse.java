package com.literalura.model;

import java.util.List;

public class ApiResponse {
    private List<ApiBook> results;

    public List<ApiBook> getResults() {
        return results;
    }

    public void setResults(List<ApiBook> results) {
        this.results = results;
    }
}
