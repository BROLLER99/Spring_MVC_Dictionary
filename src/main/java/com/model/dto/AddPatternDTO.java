package com.model.dto;

public class AddPatternDTO {
    private String description;
    private String nameOfDescription;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNameOfDescription(String nameOfDescription) {
        this.nameOfDescription = nameOfDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getNameOfDescription() {
        return nameOfDescription;
    }

    public AddPatternDTO(String description, String nameOfDescription) {
        this.description = description;
        this.nameOfDescription = nameOfDescription;
    }
}
