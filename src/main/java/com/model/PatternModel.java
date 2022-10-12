package com.model;

public class PatternModel {
    private int id;
    private String description;
    private String nameOfDescription;
    public PatternModel(String description, String nameOfDescription, int id) {
        this.description = description;
        this.nameOfDescription = nameOfDescription;
        this.id = id;
    }

    public PatternModel() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getNameOfDescription() {
        return nameOfDescription;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNameOfDescription(String nameOfDescription) {
        this.nameOfDescription = nameOfDescription;
    }
}
