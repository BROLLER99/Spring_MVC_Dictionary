package com.model.dto;

public class SearchRowByWordDTO {
    private String word;
    private Long patternId;

    public Long getPatternId() {
        return patternId;
    }

    public void setPatternId(Long patternId) {
        this.patternId = patternId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public SearchRowByWordDTO() {
    }
}
