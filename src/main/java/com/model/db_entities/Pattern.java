package com.model.db_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pattern")
public class Pattern {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patternId;
    @Column(name = "patternRule")
    private String patternRule;
    @Column(name = "patternName")
    private String patternName;

    @Override
    public String toString() {
        return "Pattern{" +
                "patternId=" + patternId +
                ", patternRule='" + patternRule + '\'' +
                ", patternName='" + patternName + '\'' +
                '}';
    }

    public Pattern() {
    }

    public Long getPatternId() {
        return patternId;
    }

    public void setPatternId(Long patternId) {
        this.patternId = patternId;
    }

    public String getPatternRule() {
        return patternRule;
    }

    public void setPatternRule(String patternRule) {
        this.patternRule = patternRule;
    }

    public String getPatternName() {
        return patternName;
    }

    public void setPatternName(String patternName) {
        this.patternName = patternName;
    }
}
