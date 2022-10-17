package com.DAO;

import com.exeption.*;
import com.utils.FileUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileWorker<T> {//todo: не совсем уверен в generics
    private static final String FILE_PATH = System.getProperty("user.dir");
    private static final String TMP_FILE = "tmp";

    public File createFile(String fileName) throws CustomException {
        try {
            File file = new File(FILE_PATH, fileName);
            if (!file.exists() && !file.createNewFile()) {
                throw new CreateFileException(fileName);
            }
            return file;
        } catch (IOException | SecurityException | NullPointerException e) {
            throw new CustomException(fileName);
        }
    }

    public void save(String fileName, String row) {
        try (FileWriter fileWriter = new FileWriter(createFile(fileName),StandardCharsets.UTF_8, true)) {
            if (createFile(fileName).length() != 0) {
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.write(row);
        } catch (SecurityException | IOException e) {
            throw new AddException(row);
        }
    }

    public void delete(String fileName, String idOfRow) {
        boolean firstRow = true;
        File tmpFile = new File(TMP_FILE + TMP_FILE + fileName);
        File file = createFile(fileName);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!FileUtils.splitAndPartsString(line).equals(idOfRow)) {
                    if(firstRow){
                        firstRow = false;
                    }else {
                        bufferedWriter.write(System.lineSeparator());
                    }
                    bufferedWriter.write(line);
                }
            }
            bufferedWriter.close();
            bufferedReader.close();
            file.delete();
            tmpFile.renameTo(file);

        } catch (NullPointerException | SecurityException | IOException e) {
            throw new DeleteExeption(tmpFile.getName());
        }
    }

    public List<T> findAll(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile(fileName), StandardCharsets.UTF_8))) {
            String line;
            List<T> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                list.add((T) FileUtils.convertFromStringToEntity(line));
            }
            bufferedReader.close();
            return list;
        } catch (NullPointerException | IOException e) {
            throw new OutputAllException();
        }
    }

}
