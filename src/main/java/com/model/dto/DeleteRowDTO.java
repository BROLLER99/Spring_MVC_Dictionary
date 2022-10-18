package com.model.dto;

public class DeleteRowDTO {
    private String idOfRow;

    public DeleteRowDTO(String idOfRow) {
        this.idOfRow = idOfRow;
    }

    public String getIdOfRow() {
        return idOfRow;
    }

    public void setIdOfRow(String idOfRow) {
        this.idOfRow = idOfRow;
    }
}
