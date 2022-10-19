package com.model.dto;

public class AddPatternDTO {
    private String patternRule;
    private String patternName;

    public void setPatternRule(String patternRule) {
        this.patternRule = patternRule;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public String getPatternRule() {
        return patternRule;
    }

    public String getPatternName() {
        return patternName;
    }

    public AddPatternDTO() {
    }
}
