package com.model.db_entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
  @ManyToOne
  @JoinColumn(name = "patternId", nullable = false)
  private String patternId;

  public Row() {
  }

  @Override
  public String toString() {
    return "Row{" +
        "idOfRow=" + idOfRow +
        ", word='" + word + '\'' +
        ", value='" + value + '\'' +
        ", patternId='" + patternId + '\'' +
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

  public String getPatternId() {
    return patternId;
  }

  public void setPatternId(String patternId) {
    this.patternId = patternId;
  }

}
