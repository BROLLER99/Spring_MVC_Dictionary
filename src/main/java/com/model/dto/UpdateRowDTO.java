package com.model.dto;

import com.model.db_entities.Pattern;

public class UpdateRowDTO {
    private Long idOfRow;
    private String word;
    private String value;
    private Pattern pattern;

    public Long getIdOfRow() {
        return idOfRow;
    }

    public void setIdOfRow(Long idOfRow) {
        this.idOfRow = idOfRow;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
