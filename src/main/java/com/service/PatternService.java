package com.service;

import com.DAO.PatternDAO;
import com.model.PatternModel;
import com.model.dto.AddPatternDTO;
import com.model.dto.DeletePatternDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatternService {
    private final PatternDAO patternDAO;

    public PatternService(PatternDAO patternDAO) {
        this.patternDAO = patternDAO;
    }

    public void save(AddPatternDTO addPatternDTO) {
        PatternModel patternModel = new PatternModel();
        patternModel.setPatternId(String.valueOf(Math.random()));
        patternModel.setPatternRule(addPatternDTO.getPatternRule());
        patternModel.setPatternName(addPatternDTO.getPatternName());
        patternDAO.save(patternModel);
    }

    public void delete(DeletePatternDTO deletePatternDTO) {
        PatternModel patternModel = new PatternModel();
        patternModel.setPatternId(deletePatternDTO.getPatternId());
        patternDAO.delete(patternModel);
    }

    public List<PatternModel> findAll() {
        return patternDAO.findAll();
    }

//    public PatternModel findById(String patternId) {
//        PatternModel patternModel = new PatternModel();
//        patternModel.setPatternId(patternId);
//        return patternDAO.findById(patternModel);
//    }
//    public String getPatternById(String idOfChosenPattern){//todo Попытка достать паттерн
//        return findById(idOfChosenPattern).get().getPatternRule();
//    }
}
