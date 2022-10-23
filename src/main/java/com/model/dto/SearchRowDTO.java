package com.model.dto;

public class SearchRowDTO {
    private String word;
    private String patternId;

    public String getPatternId() {
        return patternId;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public SearchRowDTO() {}
}
