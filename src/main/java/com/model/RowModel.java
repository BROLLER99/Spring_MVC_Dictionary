package com.model;

public class RowModel {
    private int id;
    private String word;
    private String value;
    private int pattern_id;

    public RowModel(int id, String word, String value, int pattern_id) {
        this.id = id;
        this.word = word;
        this.value = value;
        this.pattern_id = pattern_id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public RowModel() {
    }

    public void setPattern_id(int pattern_id) {
        this.pattern_id = pattern_id;
    }

    public int getId() {
        return id;
    }

    public int getPattern_id() {
        return pattern_id;
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
