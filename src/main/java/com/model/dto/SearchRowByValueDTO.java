package com.model.dto;

public class SearchRowByValueDTO {
    private String Value;
    private Long patternId;

    public SearchRowByValueDTO() {
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Long getPatternId() {
        return patternId;
    }

    public void setPatternId(Long patternId) {
        this.patternId = patternId;
    }
}
