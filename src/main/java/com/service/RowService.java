package com.service;

import com.DAO.RowDAO;
import com.model.RowModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RowService {
    private final RowDAO rowDAO;
    public RowService(RowDAO rowDAO) {
        this.rowDAO = rowDAO;
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

    public List<RowModel> findAll() {
        return  rowDAO.findAll();
    }
}
