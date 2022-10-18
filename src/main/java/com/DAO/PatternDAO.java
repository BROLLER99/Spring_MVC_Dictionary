package com.DAO;

import com.model.PatternModel;
import com.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PatternDAO implements CrudDAO<PatternModel, PatternModel> {
    private final String PATTERN_FILE_NAME = "Pattern.txt";

    private final FileWorker fileWorker;

    public PatternDAO(FileWorker fileWorker) {
        this.fileWorker = fileWorker;
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

    @Override
    public Optional<PatternModel> findById(String idOfChosenPattern) {
        return fileWorker.findById(idOfChosenPattern, PATTERN_FILE_NAME);
    }
}
