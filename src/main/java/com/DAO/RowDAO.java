package com.DAO;

import com.exeption.CustomException;
import com.model.PatternModel;
import com.model.RowModel;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.PatternSyntaxException;
@Component
public class RowDAO implements InterfaceRowDAO {
    private static final String ROW_FILE_NAME = "Row.txt";

    private File createFile() throws CustomException {
        try {
            File file = new File(FILE_PATH, ROW_FILE_NAME);
            if (!file.exists() && !file.createNewFile()) {
                throw new CustomException(CREATE_FILE_EXCEPTION);
            }
            return file;
        } catch (IOException | SecurityException | NullPointerException e) {
            throw new CustomException(CREATE_FILE_EXCEPTION);
        }
    }

    @Override
    public void save(RowModel rowModel) {
        try {
            FileWriter fileWriter = new FileWriter(createFile(), true);
            fileWriter.write(rowModel.getWord() + KEY_VALUE_SEPARATOR + rowModel.getValue() + "\n");
            fileWriter.close();
        } catch (SecurityException | IOException e) {
            throw new CustomException(ADD_EXCEPTION);
        }
    }


    @Override
    public Optional<Boolean> findById(RowModel rowModel) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (splitAndPartsString(line).equals(rowModel.getWord())) {
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
    public void delete(RowModel rowModel) {
        File tmpFile = new File(TMP_FILE + ROW_FILE_NAME);
        try {
            File file = createFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!splitAndPartsString(line).equals(rowModel.getWord())) {
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
    public List<RowModel> findAll() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile(), StandardCharsets.UTF_8))) {
            String line;
            List<RowModel> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                list.add(convertFromStringToRow(line + "\n"));
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
            String name = parts[ZERO_FOR_SPLIT].trim();
            return name;
        } catch (PatternSyntaxException e) {
            throw new CustomException(SPLIT_EXCEPTION);
        }
    }
    private RowModel convertFromStringToRow(String line){
        String[] parts = line.split(KEY_VALUE_SEPARATOR);
       RowModel row = new RowModel();
        row.setId(Integer.parseInt(parts[0].trim()));
        row.setWord(parts[1].trim());
        row.setValue(parts[2].trim());
        row.setPattern_id(Integer.parseInt(parts[3].trim()));
        return row;
    }

}
