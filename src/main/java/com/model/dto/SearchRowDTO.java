package com.model.dto;

public class SearchRowDTO {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public SearchRowDTO(String word) {
        this.word = word;
    }
}
