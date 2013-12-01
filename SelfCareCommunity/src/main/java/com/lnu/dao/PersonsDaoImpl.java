package com.lnu.dao;

import com.lnu.bean.PersonCredentials;
import com.lnu.bean.Persons;
import org.hibernate.Query;
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
    public void update(Persons person) {
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    public void createPerson(Persons person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    public Persons getPersonForCredentials(PersonCredentials credentials) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Persons where personCredentials=:personCredentials");
        query.setParameter("personCredentials",credentials);
        return (Persons) query.uniqueResult();
    }
}
