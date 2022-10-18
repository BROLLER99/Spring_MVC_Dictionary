package com.model.dto;

public class DeletePatternDTO {
    private String idOfDescription;

    public String getIdOfDescription() {
        return idOfDescription;
    }

    public void setIdOfDescription(String idOfDescription) {
        this.idOfDescription = idOfDescription;
    }

    public DeletePatternDTO(String idOfDescription) {
        this.idOfDescription = idOfDescription;
    }
}
