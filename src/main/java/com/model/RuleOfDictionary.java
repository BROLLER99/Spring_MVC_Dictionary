package com.model;

/**
 * Класс для хранения правил словаря
 */
public class RuleOfDictionary {
    String nameOfFile;
    String description;
    String pattern;

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public String getDescription() {
        return description;
    }

    public void setNameOfFile(String nameOfFile) {
        this.nameOfFile = nameOfFile;
    }

    public String getNameOfFile() {
        return nameOfFile;
    }

    public RuleOfDictionary(String nameOfFile, String description, String pattern) {
        this.nameOfFile = nameOfFile;
        this.description = description;
        this.pattern = pattern;
    }
}
