package com.DAO;

import com.exeption.CustomException;
import com.model.PatternModel;
import com.model.RowModel;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.PatternSyntaxException;
@Component
public class PatternDAO implements InterfacePatternDAO {
    private final String PATTERN_FILE_NAME = "Pattern.txt";

    private File createFile() throws CustomException {
        try {
            File file = new File(FILE_PATH, PATTERN_FILE_NAME);
            if (!file.exists() && !file.createNewFile()) {
                throw new CustomException(CREATE_FILE_EXCEPTION);
            }
            return file;
        } catch (IOException | SecurityException | NullPointerException e) {
            throw new CustomException(CREATE_FILE_EXCEPTION);
        }
    }

    @Override
    public void save(PatternModel patternName) {
        try {
            FileWriter fileWriter = new FileWriter(createFile(), StandardCharsets.UTF_8,true);
            fileWriter.write("\n" + patternName.getId() + KEY_VALUE_SEPARATOR + patternName.getNameOfDescription() + KEY_VALUE_SEPARATOR + patternName.getDescription());
            fileWriter.close();
        } catch (SecurityException | IOException e) {
            throw new CustomException(ADD_EXCEPTION);
        }
    }


    @Override
    public Optional<Boolean> findById(PatternModel patternName) {/// TODO: А оно надо вообще?
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (splitAndPartsString(line).equals(String.valueOf(patternName.getId()))) {
                    return Optional.of(false);
                }
            }
            bufferedReader.close();
            return Optional.of(true);
        } catch (IOException e) {
            throw new CustomException(SEARCH_EXCEPTION);
        }
    }

    @Override
    public void delete(PatternModel patternName) {
        File tmpFile = new File(TMP_FILE + PATTERN_FILE_NAME);
        try {
            File file = createFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!splitAndPartsString(line).equals(patternName.getNameOfDescription())) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            file.delete();
            tmpFile.renameTo(file);

        } catch (NullPointerException | SecurityException | IOException e) {
            throw new CustomException(DELETE_EXCEPTION);
        }
    }

    @Override
    public List<PatternModel> findAll() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile(), StandardCharsets.UTF_8))) {
            String line;
            List<PatternModel> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                list.add(convertFromRowToPattern(line));
            }
            bufferedReader.close();
            return list;
        } catch (NullPointerException | IOException e) {
            throw new CustomException(OUTPUT_ALL_EXCEPTION);
        }
    }

    private String splitAndPartsString(String line) throws CustomException {
        try {
            String[] parts = line.split(KEY_VALUE_SEPARATOR);
            String nameOfDescription = parts[1].trim();
            return nameOfDescription;
        } catch (PatternSyntaxException e) {
            throw new CustomException(SPLIT_EXCEPTION);
        }
    }
    private PatternModel convertFromRowToPattern(String line){
        String[] parts = line.split(KEY_VALUE_SEPARATOR);
        PatternModel pattern = new PatternModel();
        pattern.setId(Integer.parseInt(parts[0].trim()));
        pattern.setNameOfDescription(parts[1].trim());
        pattern.setDescription(parts[2].trim());
        return pattern;
    }

}
