package com.model.db_entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "row")
public class Row {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOfRow;
    @Column(name = "word")
    private String word;
    @Column(name = "value")
    private String value;
    @JoinColumn(name = "patternId")
    @ManyToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pattern pattern;

    public Row() {
    }

    @Override
    public String toString() {
        return "Row{" +
                "idOfRow=" + idOfRow +
                ", word='" + word + '\'' +
                ", value='" + value + '\'' +
                ", patternId='" + pattern + '\'' +
                '}';
    }

    public Long getIdOfRow() {
        return idOfRow;
    }

    public void setIdOfRow(Long idOfRow) {
        this.idOfRow = idOfRow;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern patternId) {
        this.pattern = patternId;
    }

}
