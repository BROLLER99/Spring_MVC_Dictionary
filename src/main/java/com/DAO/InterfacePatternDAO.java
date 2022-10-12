package com.DAO;

import com.model.PatternModel;

import java.util.List;
import java.util.Optional;

public interface InterfacePatternDAO extends InterfaceOfEntity {

    void save(PatternModel patternName);

    Optional<Boolean> findById(PatternModel patternName);

    void delete(PatternModel patternName);
    List<PatternModel> findAll();
}
