package com.service;

import com.DAO.RowDAO;
import com.model.db_entities.Row;
import com.model.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RowService {
    private static final String EMPTY = "Пусто";
    private final RowDAO rowDAO;
    private final PatternService patternService;

    public RowService(RowDAO rowDAO, PatternService patternService) {
        this.rowDAO = rowDAO;
        this.patternService = patternService;
    }

    @Transactional
    public boolean save(AddRowDTO addRowDTO) {
        Row row = new Row();
        boolean result = addRowDTO.getWord().matches(patternService.findById(addRowDTO.getIdOfChosenPattern()).getPatternRule());
        if (result) {
            row.setWord(addRowDTO.getWord());
            row.setValue(addRowDTO.getValue());
            row.setPattern(patternService.findById(addRowDTO.getIdOfChosenPattern()));
            rowDAO.save(row);
            return true;
        }
        return false;
    }

    @Transactional
    public List<Row> findByName(SearchRowByWordDTO searchRowByWordDTO) {
        return rowDAO.findByName(searchRowByWordDTO.getWord(), searchRowByWordDTO.getPatternId());
    }
    @Transactional
    public List<Row> findByValue(SearchRowByValueDTO searchRowByValueDTO) {
        return rowDAO.findByValue(searchRowByValueDTO.getValue(), searchRowByValueDTO.getPatternId());
    }

    @Transactional
    public void delete(DeleteRowDTO deleteRowDTO) {
        Row row = new Row();
        row.setIdOfRow(deleteRowDTO.getIdOfRow());
        rowDAO.delete(row);
    }

    @Transactional
    public List<Row> findRowsByPattern(String idOfChosenPattern) {
        return rowDAO.findByPattern(Long.valueOf(idOfChosenPattern));
    }

    @Transactional
    public void update(UpdateRowDTO updateRow) {
        Row row = new Row();
        boolean result = updateRow.getWord().matches(patternService.findById(updateRow.getPatternId()).getPatternRule());
        if (result) {
            row.setIdOfRow(updateRow.getIdOfRow());
            row.setWord(updateRow.getWord());
            row.setValue(updateRow.getValue());
            row.setPattern(patternService.findById(updateRow.getPatternId()));
            rowDAO.update(row);
        }
    }
}
