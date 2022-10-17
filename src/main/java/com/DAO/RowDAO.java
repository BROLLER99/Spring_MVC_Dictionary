package com.DAO;

import com.exeption.CustomException;
import com.exeption.SearchException;
import com.model.RowModel;
import com.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.Optional;


@Component
public class RowDAO implements CrudDAO<RowModel, RowModel> {
    private static final String ROW_FILE_NAME = "Row.txt";

    private final FileWorker fileWorker;

    public RowDAO(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    private File createFile() throws CustomException {
        return fileWorker.createFile(ROW_FILE_NAME);
    }

    @Override
    public void save(RowModel rowModel) {
        String row = FileUtils.toFileEntry(rowModel.getIdOfRow(), rowModel.getWord(), rowModel.getValue(), rowModel.getPatternId());
        fileWorker.save(ROW_FILE_NAME, row);
    }

    public Optional<Boolean> findById(RowModel rowModel) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (FileUtils.splitAndPartsString(line).equals(rowModel.getIdOfRow())) {
                    return Optional.of(false);
                }
            }
            bufferedReader.close();
            return Optional.of(true);
        } catch (IOException e) {
            throw new SearchException(rowModel.getWord());
        }
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
