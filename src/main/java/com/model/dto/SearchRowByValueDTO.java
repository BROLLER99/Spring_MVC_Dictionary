package com.model.dto;

public class SearchRowByValueDTO {
    private String Value;
    private String patternId;

    public SearchRowByValueDTO() {
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getPatternId() {
        return patternId;
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }
}
