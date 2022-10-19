package com.model.dto;

public class DeletePatternDTO {
    @Override
    public String toString() {
        return "DeletePatternDTO{" +
                "patternId='" + patternId + '\'' +
                '}';
    }

    private String patternId;

    public String getPatternId() {
        return patternId;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public DeletePatternDTO(){};
}
