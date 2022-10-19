package com.model.dto;

public class AddRowDTO {
    private String idOfChosenPattern;
    private String word;
    private String value;

    @Override
    public String toString() {
        return "AddRowDTO{" +
                "idOfChosenPattern='" + idOfChosenPattern + '\'' +
                ", word='" + word + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getIdOfChosenPattern() {
        return idOfChosenPattern;
    }

    public void setIdOfChosenPattern(String idOfChosenPattern) {
        this.idOfChosenPattern = idOfChosenPattern;
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

    public AddRowDTO() {
    }
}
