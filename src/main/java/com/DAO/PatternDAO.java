//package com.DAO;
//
//import com.models.PatternModel;
//import com.utils.FileUtils;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.utils.FileUtils.*;
//
//@Component
//public class PatternDAO implements CrudDAO<PatternModel> {
//    private final String PATTERN_FILE_NAME = "Pattern.txt";
//
//    private final FileWorker fileWorker;
//
//    public PatternDAO(FileWorker fileWorker) {
//        this.fileWorker = fileWorker;
//    }
//
//    @Override
//    public void save(PatternModel patternModel) {
//        String row = FileUtils.toFileEntry(patternModel.getPatternId(), patternModel.getPatternName(), patternModel.getPatternRule());
//        fileWorker.save(PATTERN_FILE_NAME, row);
//    }
//
//    @Override
//    public void delete(PatternModel patternModel) {
//        String rowWithId = FileUtils.toFileEntry(patternModel.getPatternId());//todo Норм?
//        fileWorker.delete(PATTERN_FILE_NAME, rowWithId);
//    }
//
//    @Override
//    public List<PatternModel> findAll() {
//        List<PatternModel> list = new ArrayList<>();
//        List<String> listPatterns = fileWorker.findAll(PATTERN_FILE_NAME);
//        for (String line : listPatterns){
//           list.add(fromStringToModel(line));
//        }
//        return list;
//    }
//
//    @Override
//    public PatternModel findById(PatternModel patternModel) {
//        String rowWithId = FileUtils.toFileEntry(patternModel.getPatternId());
//        return fromStringToModel(fileWorker.findById(rowWithId, PATTERN_FILE_NAME));
//    }
//    private PatternModel fromStringToModel(String line){
//        String[] parts = line.split(SEPARATOR);
//        PatternModel patternModel = new PatternModel();
//        patternModel.setPatternId((parts[ZERO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim()));
//        patternModel.setPatternName(parts[ONE_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
//        patternModel.setPatternRule(parts[TWO_FOR_FIRST_PART_OF_ROW_IN_SPLIT].trim());
//        return patternModel;
//    }
//}
