package com.DAO;

import com.exeption.CustomException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import static com.service.MainService.getNameOfFile;

/**
 * Класс реализует методы интерфейса InterfaceDictionary по работе с файлом
 */
public class LocalStorageDAO implements StorageDAO {
    private static final String FILE_PATH = System.getProperty("user.dir");
    private static final String CREATE_FILE_EXCEPTION = "Ошибка создания файла";
    private static final String SPLIT_EXCEPTION = "Ошибка разделения строки";
    private static final String TMP_FILE = "tmp";
    private static final int ZERO_FOR_SPLIT = 0;


    /**
     * Реализация метода добавления записи в файл, интерфейса InterfaceDictionary
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     * @throws CustomException If a security manager exists and method denies write access to the file (SecurityException)
     *                         If an I/O error occurs(IOException)
     */
    @Override
    public void addElement(String key, String value) throws CustomException {
        try {
            FileWriter fileWriter = new FileWriter(createFile(), true);
            fileWriter.write(key + KEY_VALUE_SEPARATOR + value + "\n");
            fileWriter.close();
        } catch (SecurityException | IOException e) {
            throw new CustomException(ADD_EXCEPTION);
        }
    }

    /**
     * Реализация метода вывода всех записей из файла, интерфейса InterfaceDictionary
     *
     * @return возвращает строку в которой содержаться все элементы
     * @throws CustomException If an I/O error occurs(IOException)
     *                         if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public List<String> outputAllElements() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            List<String> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line + "\n");
            }
            bufferedReader.close();
            return list;
        } catch (NullPointerException | IOException e) {
            throw new CustomException(OUTPUT_ALL_EXCEPTION);
        }
    }


    /**
     * Реализация метода поиска записи в файле, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     * @return true если элемент найден и false если нет
     * @throws CustomException If an I/O error occurs(IOException)
     */
    @Override
    public boolean searchElement(String key) throws CustomException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createFile()))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (splitAndPartsString(line).equals(key)) {
                    return true;
                }
            }
            bufferedReader.close();
            return false;
        } catch (IOException e) {
            throw new CustomException(SEARCH_EXCEPTION);
        }
    }

    /**
     * Реализация метода удаления записи в файле, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     * @throws CustomException If an I/O error occurs(IOException)
     *                         if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                         If a security manager exists and method denies write access to the file (SecurityException)
     */
    @Override
    public void deleteElement(String key) throws CustomException {
        File tmpFile = new File(TMP_FILE + getNameOfFile());
        try {
            File file = createFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(tmpFile));
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (!splitAndPartsString(line).equals(key)) {
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

    private File createFile() throws CustomException {
        try {
            File file = new File(FILE_PATH, getNameOfFile());
            if (!file.exists() && !file.createNewFile()) {
                throw new CustomException(CREATE_FILE_EXCEPTION);
            }
            return file;
        } catch (IOException | SecurityException | NullPointerException e) {
            throw new CustomException(CREATE_FILE_EXCEPTION);
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
}
