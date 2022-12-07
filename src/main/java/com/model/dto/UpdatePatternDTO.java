package com.model.dto;

public class UpdatePatternDTO {
    private String patternName;
    private Long patternId;
    private String patternRule;

    public String getPatternRule() {
        return patternRule;
    }

    public void setPatternRule(String patternRule) {
        this.patternRule = patternRule;
    }

    public UpdatePatternDTO() {
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }

    public Long getPatternId() {
        return patternId;
    }

    public void setPatternId(Long patternId) {
        this.patternId = patternId;
    }
}
