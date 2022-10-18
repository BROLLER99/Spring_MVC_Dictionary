package com.service;

import com.DAO.PatternDAO;
import com.model.PatternModel;
import com.model.dto.AddPatternDTO;
import com.model.dto.DeletePatternDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatternService {
    private final PatternDAO patternDAO;

    public PatternService(PatternDAO patternDAO) {
        this.patternDAO = patternDAO;
    }

    public void save(AddPatternDTO addPatternDTO) {
        PatternModel patternModel = new PatternModel();
        patternModel.setIdOfDescription(String.valueOf(Math.random()));
        patternModel.setDescription(addPatternDTO.getDescription());
        patternModel.setNameOfDescription(addPatternDTO.getNameOfDescription());
        patternDAO.save(patternModel);
    }

    public void delete(DeletePatternDTO deletePatternDTO) {
        PatternModel patternModel = new PatternModel();
        patternModel.setIdOfDescription(deletePatternDTO.getIdOfDescription());
        patternDAO.delete(patternModel);
    }

    public List<PatternModel> findAll() {
        return patternDAO.findAll();
    }

    public Optional<PatternModel> findById(String idOfChosenPattern) {
        return patternDAO.findById(idOfChosenPattern);
    }
//    public String getPatternById(String idOfChosenPattern){//todo Попытка достать паттерн
//        return findById(idOfChosenPattern).get().getDescription();
//    }
}
