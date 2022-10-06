package com.DAO;

import com.exeption.CustomException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс реализует методы интерфейса InterfaceDictionary по работе с map
 */
public class RunTimeStorage implements Storage {
    /**
     * Объект dictionary который будет хранить коллекцию Map
     */
    private final Map<String, String> dictionary = new HashMap<>();

    /**
     * Реализация метода добавления записи в map, интерфейса InterfaceDictionary
     *
     * @param key   - аргумент, хранящий ключ - слово, который необходимо добавить
     * @param value - аргумент, хранящий слово - значение, который необходимо добавить
     * @throws CustomException if the put operation is not supported by this map(UnsupportedOperationException)
     *                         if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                         if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                         if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    @Override
    public void addElement(String key, String value) {
        try {
            dictionary.put(key, value);
        } catch (IllegalArgumentException | NullPointerException | ClassCastException |
                 UnsupportedOperationException e) {
            throw new CustomException(ADD_EXCEPTION);
        }
    }

    /**
     * Реализация метода удаления записи из map, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо удалить
     * @throws CustomException if the put operation is not supported by this map(UnsupportedOperationException)
     *                         if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                         if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public void deleteElement(String key) {
        try {
            dictionary.remove(key);
        } catch (NullPointerException | ClassCastException | UnsupportedOperationException e) {
            throw new CustomException(DELETE_EXCEPTION);
        }
    }

    /**
     * Реализация метода поиска записи в map, интерфейса InterfaceDictionary
     *
     * @param key - аргумент, хранящий ключ - слово, который необходимо найти
     * @return true если элемент найден и false если нет
     * @throws CustomException if the class of the specified key or value prevents it from being stored in this map(ClassCastException)
     *                         if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     */
    @Override
    public boolean searchElement(String key) {
        try {
            return dictionary.containsKey(key);
        } catch (ClassCastException | NullPointerException e) {
            throw new CustomException(SEARCH_EXCEPTION);
        }
    }

    /**
     * Реализация метода вывода всех записей из map, интерфейса InterfaceDictionary
     *
     * @return возвращает строку в которой содержаться все элементы
     * @throws CustomException if the specified key or value is null and this map does not permit null keys or values(NullPointerException)
     *                         if some property of the specified key or value prevents it from being stored in this map(IllegalArgumentException)
     */
    @Override
    public List<String> outputAllElements() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            List<String> list = new ArrayList<String>();
            for (Map.Entry<String, String> pair : dictionary.entrySet()) {
                String key = pair.getKey();
                String value = pair.getValue();
                stringBuilder.append(key).append(KEY_VALUE_SEPARATOR).append(value).append("\n");
                list.add(stringBuilder.toString());
            }
            return list;
        } catch (IllegalStateException | NullPointerException e) {
            throw new CustomException(OUTPUT_ALL_EXCEPTION);
        }
    }

}
