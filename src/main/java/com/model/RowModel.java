package com.model;

public class RowModel {
    private String id;
    private String word;
    private String value;
    private String patternID;

    public RowModel(String id, String word, String value, String patternID) {
        this.id = id;
        this.word = word;
        this.value = value;
        this.patternID = patternID;
    }
    public void setId(String id) {
        this.id = id;
    }

    public RowModel() {
    }

    public void setPatternID(String patternID) {
        this.patternID = patternID;
    }

    public String getId() {
        return id;
    }

    public String getPatternID() {
        return patternID;
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
