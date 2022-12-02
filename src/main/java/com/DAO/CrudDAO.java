package com.DAO;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CrudDAO<T> extends CrudRepository<T, Integer> {

  void save(T patternName);

  void delete(T patternName);

  List<T> findAll();

  T findById(T chosenId);//todo Убрал Optional

}
