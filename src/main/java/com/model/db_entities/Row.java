package com.model.db_entities;

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
  @Column(name = "patternId")
  private Long patternId;

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

  public Long getPatternId() {
    return patternId;
  }

  public void setPatternId(Long patternId) {
    this.patternId = patternId;
  }

}
