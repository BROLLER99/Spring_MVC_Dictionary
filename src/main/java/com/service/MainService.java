package com.service;

import com.DAO.Storage;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class MainService {
    private final Storage storage;
    private static String nameOfFile;

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

    public void setNameOfFile(String nameOfFile) {
        MainService.nameOfFile = nameOfFile;
    }

    public static String getNameOfFile() {
        return nameOfFile;
    }
}
