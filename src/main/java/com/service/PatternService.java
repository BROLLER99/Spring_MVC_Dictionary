package com.service;

import com.DAO.PatternDAO;
import com.model.PatternModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternService {
    private final PatternDAO patternDAO;

    public PatternService(PatternDAO patternDAO) {
        this.patternDAO = patternDAO;
    }

    public void save(PatternModel patternModel) {
        patternDAO.save(patternModel);
    }

    public void delete(PatternModel patternModel) {
        patternDAO.delete(patternModel);
    }

    public List<PatternModel> findAll() {
        return patternDAO.findAll();
    }

    public PatternModel findById(String idOfChosenPattern) {
        return patternDAO.findById(idOfChosenPattern);
    }
    public String getPatternById(String idOfChosenPattern){//todo Попытка достать паттерн
        return findById(idOfChosenPattern).getDescription();
    }
}
