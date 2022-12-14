package com.service;

import com.DAO.PatternDAO;
import com.model.db_entities.Pattern;
import com.model.dto.AddPatternDTO;
import com.model.dto.DeletePatternDTO;
import com.model.dto.UpdatePatternDTO;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Service
public class PatternService {

    private final PatternDAO patternDAO;

    public PatternService(PatternDAO patternDAO) {
        this.patternDAO = patternDAO;
    }

    @Transactional
    public void save(AddPatternDTO addPatternDTO) {
        Pattern pattern = new Pattern();
        pattern.setPatternRule(addPatternDTO.getPatternRule());
        pattern.setPatternName(addPatternDTO.getPatternName());
        patternDAO.save(pattern);
    }

    @Transactional
    public void delete(DeletePatternDTO deletePatternDTO) {
        Pattern pattern = new Pattern();
        pattern.setPatternId(deletePatternDTO.getPatternId());
        patternDAO.delete(pattern);
    }

    @Transactional
    public List<Pattern> findAll() {
        return patternDAO.findAll();
    }

    @Transactional
    public Pattern findById(Long patternId) {
        return patternDAO.findById(patternId);
    }
    @Transactional
    public void update(UpdatePatternDTO updatePatternDTO) {
        Pattern pattern = new Pattern();
        pattern.setPatternName(updatePatternDTO.getPatternName());
        pattern.setPatternId(updatePatternDTO.getPatternId());
        pattern.setPatternRule(updatePatternDTO.getPatternRule());
        patternDAO.update(pattern);
    }
}
