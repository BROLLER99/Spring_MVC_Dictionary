package com.DAO;

import com.model.db_entities.Pattern;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatternDAO implements CrudDAO<Pattern,Long> {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Pattern pattern) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(pattern);
    }

    @Override
    public void delete(Pattern pattern) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(pattern);
    }

    @Override
    public List<Pattern> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Pattern").list();
    }

    @Override
    public Pattern findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Pattern.class, id);
    }
}
