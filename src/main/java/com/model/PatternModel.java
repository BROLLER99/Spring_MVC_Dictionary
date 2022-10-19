package com.model;

public class PatternModel {
    private String patternId;
    private String patternRule;
    private String patternName;
    public PatternModel(String patternRule, String patternName, String patternId) {
        this.patternRule = patternRule;
        this.patternName = patternName;
        this.patternId = patternId;
    }

    public PatternModel() {
    }

    public void setPatternId(String patternId) {
        this.patternId = patternId;
    }

    public String getPatternId() {
        return patternId;
    }

    public String getPatternRule() {
        return patternRule;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternRule(String patternRule) {
        this.patternRule = patternRule;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }
}
