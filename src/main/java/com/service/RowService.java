package com.service;

import com.DAO.RowDAO;
import com.model.db_entities.Row;
import com.model.dto.AddRowDTO;
import com.model.dto.DeleteRowDTO;
import com.model.dto.SearchRowDTO;
import com.model.dto.UpdateRowDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RowService {
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
    public List<Row> findByName(SearchRowDTO searchRowDTO) {
        List<Row> list = new ArrayList<>();
        for (Row row : findAll()) {
            if ((row.getWord().toUpperCase().contains(searchRowDTO.getWord().toUpperCase())) && (Objects.equals(row.getPattern().getPatternId().toString(), searchRowDTO.getPatternId()))) {
                list.add(row);
            }
        }
        return list;
    }

    @Transactional
    public void delete(DeleteRowDTO deleteRowDTO) {
        Row row = new Row();
        row.setIdOfRow(deleteRowDTO.getIdOfRow());
        rowDAO.delete(row);
    }

    @Transactional
    public List<Row> findRowsByPattern(String idOfChosenPattern) {
        List<Row> listRowWithRule = new ArrayList<>();
        for (Row row : findAll()) {
            if (Objects.equals(row.getPattern().getPatternId().toString(), idOfChosenPattern)) {
                listRowWithRule.add(row);
            }
        }
        return listRowWithRule;
    }

    @Transactional
    public List<Row> findAll() {
        return rowDAO.findAll();
    }
    @Transactional
    public void update(UpdateRowDTO updateRow){
        Row row = new Row();
        row.setIdOfRow(updateRow.getIdOfRow());
        row.setWord(updateRow.getWord());
        row.setValue(updateRow.getValue());
        rowDAO.update(row);
    }
}
