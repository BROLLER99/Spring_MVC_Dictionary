package com.DAO;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CrudDAO<T,ID> {

  void save(T entity);

  void delete(T entity);

  List<T> findAll();

  T findById(ID chosenId);

}
