package com.model;

public class PatternModel {
    private String id;
    private String description;
    private String nameOfDescription;
    public PatternModel(String description, String nameOfDescription, String id) {
        this.description = description;
        this.nameOfDescription = nameOfDescription;
        this.id = id;
    }

    public PatternModel() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
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
