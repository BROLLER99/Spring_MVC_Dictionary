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

    public void findById(PatternModel patternModel) {
        patternDAO.findById(patternModel);
    }

    public void delete(PatternModel patternModel) {
        patternDAO.delete(patternModel);
    }

    public List<PatternModel> findAll() {
        List<PatternModel> all = patternDAO.findAll();
        return patternDAO.findAll();
    }
}
