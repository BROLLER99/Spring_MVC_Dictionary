package com.model.dto;

public class DeletePatternDTO {
    @Override
    public String toString() {
        return "DeletePatternDTO{" +
                "patternId='" + patternId + '\'' +
                '}';
    }

    private Long patternId;

    public Long getPatternId() {
        return patternId;
    }

    public void setPatternId(Long patternId) {
        this.patternId = patternId;
    }

    public DeletePatternDTO() {
    }

    ;
}
