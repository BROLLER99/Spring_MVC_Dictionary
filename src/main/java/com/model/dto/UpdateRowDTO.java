package com.model.dto;

public class UpdateRowDTO {
    private Long idOfRow;
    private String word;
    private String value;
    private Long patternId;

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

    public Long getPatternId() {
        return patternId;
    }

    public void setPatternId(Long patternId) {
        this.patternId = patternId;
    }
}
