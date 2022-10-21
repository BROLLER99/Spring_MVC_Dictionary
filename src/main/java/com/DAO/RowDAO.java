package com.DAO;

import com.model.RowModel;
import com.utils.FileUtils;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

import static com.utils.FileUtils.*;


@Component
public class RowDAO implements CrudDAO<RowModel> {
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
    public RowModel findById(RowModel rowModel) {
        String row = FileUtils.toFileEntry(rowModel.getIdOfRow());
        return fromStringToModel(fileWorker.findById(row,ROW_FILE_NAME));
    }
    @Override
    public void delete(RowModel rowModel) {
        String rowWithId = FileUtils.toFileEntry(rowModel.getIdOfRow());
        fileWorker.delete(ROW_FILE_NAME, rowWithId );
    }

    @Override
    public List<RowModel> findAll() {
        List<RowModel> list = new ArrayList<>();
        List<String> listPatterns = fileWorker.findAll(ROW_FILE_NAME);
        for (String line : listPatterns){
            list.add(fromStringToModel(line));
        }
        return list;
    }
    private RowModel fromStringToModel(String line) {
        String[] parts = line.split(SEPARATOR);
        RowModel rowModel = new RowModel();
        rowModel.setIdOfRow(parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
        rowModel.setWord(parts[ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
        rowModel.setValue(parts[TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
        rowModel.setPatternId(parts[THREE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
        return rowModel;
    }

}

