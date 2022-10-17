package com.model;

public class PatternModel {
    private String idOfDescription;
    private String description;
    private String nameOfDescription;
    public PatternModel(String description, String nameOfDescription, String idOfDescription) {
        this.description = description;
        this.nameOfDescription = nameOfDescription;
        this.idOfDescription = idOfDescription;
    }

    public PatternModel() {
    }

    public void setIdOfDescription(String idOfDescription) {
        this.idOfDescription = idOfDescription;
    }

    public String getIdOfDescription() {
        return idOfDescription;
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
