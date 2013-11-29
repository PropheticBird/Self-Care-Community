package com.lnu.dao;

import com.lnu.bean.PersonCredentials;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * User: igor
 * Date: 11/28/13
 */
@Repository
public class PersonalCredentialsDaoImpl implements PersonalCredentialsDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void savePersonalCredentials(PersonCredentials user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
