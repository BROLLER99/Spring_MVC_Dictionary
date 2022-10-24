package com.model;

public class RowModel {
    private String idOfRow;
    private String word;
    private String value;
    private String patternId;

    @Override
    public String toString() {
        return "RowModel{" +
                "idOfRow='" + idOfRow + '\'' +
                ", word='" + word + '\'' +
                ", value='" + value + '\'' +
                ", patternId='" + patternId + '\'' +
                '}';
    }

    public RowModel(String idOfRow, String word, String value, String patternId) {
        this.idOfRow = idOfRow;
        this.word = word;
        this.value = value;
        this.patternId = patternId;
    }

    public void setIdOfRow(String idOfRow) {
        this.idOfRow = idOfRow;
    }

    public RowModel() {
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public String getIdOfRow() {
        return idOfRow;
    }

    public String getPatternId() {
        return patternId;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getWord() {
        return word;
    }

    public String getValue() {
        return value;
    }
}
