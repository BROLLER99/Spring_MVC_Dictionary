package com.DAO;

public interface InterfaceOfEntity {
    String FILE_PATH = System.getProperty("user.dir");//todo где это хранить
    String CREATE_FILE_EXCEPTION = "Ошибка создания файла";
    String ADD_EXCEPTION = "Ошибка добавления элемента";
    String DELETE_EXCEPTION = "Ошибка удаления элемента";
    String SEARCH_EXCEPTION = "Ошибка поиска элемента";
    String OUTPUT_ALL_EXCEPTION = "Ошибка вывода всех элементов";
    String KEY_VALUE_SEPARATOR = ":";
    String TMP_FILE = "tmp";
    String SPLIT_EXCEPTION = "Ошибка разделения строки";
    int ZERO_FOR_SPLIT = 0;

}
