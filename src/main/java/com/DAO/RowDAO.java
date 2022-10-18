package com.DAO;

import com.model.RowModel;
import com.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class RowDAO implements CrudDAO<RowModel, RowModel> {
    private static final String ROW_FILE_NAME = "Row.txt";

    private final FileWorker fileWorker;

    public RowDAO(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    @Override
    public void save(RowModel rowModel) {
        String row = FileUtils.toFileEntry(rowModel.getIdOfRow(), rowModel.getWord(), rowModel.getValue(), rowModel.getPatternId());
        fileWorker.save(ROW_FILE_NAME, row);
    }

    @Override
    public Optional<RowModel> findById(String chosenId) {
        return fileWorker.findById(chosenId,ROW_FILE_NAME);
    }
    @Override
    public void delete(RowModel rowModel) {
        fileWorker.delete(ROW_FILE_NAME, rowModel.getIdOfRow());
    }

    @Override
    public List<RowModel> findAll() {
        return fileWorker.findAll(ROW_FILE_NAME);
    }

}
