package com.model;

/**
 * Класс для хранения правил словаря
 */
public class RuleOfDictionary {
    String nameOfFile;
    String description;

    public void setDescription(String description) {
        this.description = description;
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

    public RuleOfDictionary(String nameOfFile, String description) {
        this.nameOfFile = nameOfFile;
        this.description = description;
    }
}
