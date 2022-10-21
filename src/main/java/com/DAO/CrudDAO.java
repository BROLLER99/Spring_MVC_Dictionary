package com.DAO;

import java.util.List;

public interface CrudDAO<T>{
    void save(T patternName);
    void delete(T patternName);
    List<T> findAll();
    T findById(T chosenId);//todo Убрал Optional

}
