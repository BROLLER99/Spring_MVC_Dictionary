package com.service;

import com.DAO.RowDAO;
import com.model.RowModel;
import com.model.dto.AddRowDTO;
import com.model.dto.DeleteRowDTO;
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
    public void save(AddRowDTO addRowDTO) {
        RowModel rowModel = new RowModel();
        rowModel.setIdOfRow(String.valueOf(Math.random()));
        rowModel.setWord(addRowDTO.getWord());
        rowModel.setValue(addRowDTO.getValue());
        rowModel.setPatternId(addRowDTO.getIdOfChosenPattern());
        rowDAO.save(rowModel);
    }

//    public void findById(String ChosenId) {
//        rowDAO.findById(ChosenId);
//    }

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
        return  rowDAO.findAll();
    }
}
