package com.service;

import com.DAO.StorageDAO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MainService {
    private final static String THERE_IS_NO_SUCH_KEY = "Такого ключа нет";
    private final static String THERE_IS_SUCH_KEY = "Есть такой ключ ";
    private final StorageDAO storageDAO;
    private static String nameOfFile;

    public MainService(StorageDAO storageDAO) {
        this.storageDAO = storageDAO;
    }

    public void addElement(String key, String value) {
        storageDAO.addElement(key, value);
    }

    public void deleteElement(String key) {
        storageDAO.deleteElement(key);
    }

    public String searchElement(String key) {
        if (storageDAO.searchElement(key))
            return THERE_IS_SUCH_KEY + key;
        return THERE_IS_NO_SUCH_KEY;
    }

    public List<String> outputAllElements() throws IOException {
        return storageDAO.outputAllElements();
    }

    public void setNameOfFile(String nameOfFile) {
        MainService.nameOfFile = nameOfFile;
    }

    public static String getNameOfFile() {
        return nameOfFile;
    }
}
