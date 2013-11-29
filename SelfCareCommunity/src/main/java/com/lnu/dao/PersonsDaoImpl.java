package com.lnu.dao;

import com.lnu.bean.Persons;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User: igor
 * Date: 11/29/13
 */
@Repository
public class PersonsDaoImpl implements PersonsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Persons getPersonById(Long id) {
        return (Persons) sessionFactory.getCurrentSession().get(Persons.class,id);
    }
}
