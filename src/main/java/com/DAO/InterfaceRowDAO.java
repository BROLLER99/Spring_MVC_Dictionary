package com.DAO;

import com.model.PatternModel;
import com.model.RowModel;

import java.util.List;
import java.util.Optional;

public interface InterfaceRowDAO extends InterfaceOfEntity {

    void save(RowModel rowModel);

    Optional<Boolean> findById(RowModel rowModel);

    void delete(RowModel rowModel);
    List<RowModel> findAll();
}

