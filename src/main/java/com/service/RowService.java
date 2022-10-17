package com.service;

import com.DAO.RowDAO;
import com.model.PatternModel;
import com.model.RowModel;
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
    public void save(RowModel rowModel) {
        rowDAO.save(rowModel);
    }

    public void findById(RowModel rowModel) {
        rowDAO.findById(rowModel);
    }

    public void delete(RowModel rowModel) {
        rowDAO.delete(rowModel);
    }

    public List<RowModel> findRuleById(String idOfChosenPattern) {
        PatternModel patternModel = patternService.findById(idOfChosenPattern);
        List<RowModel> listRow = findAll();
        List<RowModel> listRowWithRule = new ArrayList<>();
        for (RowModel rowModel : listRow) {
            if (Objects.equals(rowModel.getPatternId(), patternModel.getIdOfDescription())) {
                listRowWithRule.add(rowModel);
            }
        }
        return listRowWithRule;
    }
    private List<RowModel> findAll() {
        return  rowDAO.findAll();
    }
}
