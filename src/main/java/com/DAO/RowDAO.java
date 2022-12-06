package com.DAO;

import com.model.db_entities.Row;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class RowDAO implements CrudDAO<Row, Long> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Row row) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(row);
    }

    @Override
    public void delete(Row row) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(row);
    }

    @Override
    public List<Row> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Row").list();
    }

    @Override
    public Row findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Row.class, id);
    }

    @Override
    public void update(Row row) {
        Session session = sessionFactory.getCurrentSession();
        session.update(row);
    }
}

