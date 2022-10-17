package com.DAO;

import com.exeption.CustomException;
import com.exeption.SearchException;
import com.model.PatternModel;
import com.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class PatternDAO implements CrudDAO<PatternModel, PatternModel> {
    private final String PATTERN_FILE_NAME = "Pattern.txt";

    private final FileWorker fileWorker;

    public PatternDAO(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
    }

    private File createFile() throws CustomException {
        return fileWorker.createFile(PATTERN_FILE_NAME);
    }

    @Override
    public void save(PatternModel patternName) {
        String row = FileUtils.toFileEntry(patternName.getIdOfDescription(), patternName.getNameOfDescription(), patternName.getDescription());
        fileWorker.save(PATTERN_FILE_NAME, row);
    }

    @Override
    public void delete(PatternModel patternName) {
        fileWorker.delete(PATTERN_FILE_NAME, patternName.getIdOfDescription());
    }

    @Override
    public List<PatternModel> findAll() {
        return fileWorker.findAll(PATTERN_FILE_NAME);
    }

    public PatternModel findById(String idOfChosenPattern) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (FileUtils.splitAndPartsString(line).equals(idOfChosenPattern)) {
                    return (PatternModel) FileUtils.convertFromStringToEntity(line);
                }
            }
            bufferedReader.close();
            return new PatternModel();//todo Норм?
        } catch (IOException e) {
            throw new SearchException(idOfChosenPattern);
        }
    }
}
