package com.service;

import com.DAO.RowDAO;
import com.model.RowModel;
import com.model.dto.AddRowDTO;
import com.model.dto.DeleteRowDTO;
import com.model.dto.SearchRowDTO;
import org.springframework.stereotype.Service;

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

    public boolean save(AddRowDTO addRowDTO) {
        RowModel rowModel = new RowModel();
        String rule = patternService.findById(addRowDTO.getIdOfChosenPattern()).getPatternRule();
        String word= addRowDTO.getWord();
        boolean result = word.matches(rule);
        if(addRowDTO.getWord().matches(rule)) {
            rowModel.setWord(addRowDTO.getWord());
            rowModel.setIdOfRow(String.valueOf(Math.random()));
            rowModel.setValue(addRowDTO.getValue());
            rowModel.setPatternId(addRowDTO.getIdOfChosenPattern());
            rowDAO.save(rowModel);
            return result;
        }
        return result;
    }

    public List<RowModel> findByName(SearchRowDTO searchRowDTO) {
        List<RowModel> list = new ArrayList<>();
        for (RowModel rowModel : findAll()) {
            if ((rowModel.getWord().toUpperCase().contains(searchRowDTO.getWord().toUpperCase())) && (Objects.equals(rowModel.getPatternId(), searchRowDTO.getPatternId()))) {
                list.add(rowModel);
            }
        }
        return list;
    }

    public void delete(DeleteRowDTO deleteRowDTO) {
        RowModel rowModel = new RowModel();
        rowModel.setIdOfRow(deleteRowDTO.getIdOfRow());
        rowDAO.delete(rowModel);
    }

    public List<RowModel> findRowsByPattern(String idOfChosenPattern) {
//        PatternModel patternModel = patternService.findById(idOfChosenPattern);//todo Мб вернуть так?
        List<RowModel> listRowWithRule = new ArrayList<>();
        for (RowModel rowModel : findAll()) {
            if (Objects.equals(rowModel.getPatternId(), idOfChosenPattern)) {
                listRowWithRule.add(rowModel);
            }
        }
        return listRowWithRule;
    }

    private List<RowModel> findAll() {
        return rowDAO.findAll();
    }
}
