package com.DAO;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T,ID>{
    void save(T patternName);
    void delete(T patternName);
    List<T> findAll();
    Optional<T> findById(ID chosenId);

}
