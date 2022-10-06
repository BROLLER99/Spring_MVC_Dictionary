package com.service;

import com.DAO.Storage;
import com.exeption.CustomException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class MainService {
    private static final String FILE_PATH = System.getProperty("user.dir");
    private static final String CREATE_FILE_EXCEPTION = "Ошибка создания файла";
    private final Storage storage;
    private static File file;

    public MainService(Storage storage) {
        this.storage = storage;
    }

    public void addElement(String key, String value) {
        storage.addElement(key, value);
    }

    public void deleteElement(String key) {
        storage.deleteElement(key);
    }

    public boolean searchElement(String key) {
        return storage.searchElement(key);
    }

    public List<String> outputAllElements() throws IOException {
        return storage.outputAllElements();
    }

    public void createFile(String nameOfFile) {
        try {
            file = new File(FILE_PATH, nameOfFile);
            if (!file.exists() && !file.createNewFile()) {
                throw new CustomException(CREATE_FILE_EXCEPTION);
            }
        } catch (IOException | SecurityException | NullPointerException e) {
            throw new CustomException(CREATE_FILE_EXCEPTION);
        }
    }
    public static File getFile() {
        return file;
    }
}
