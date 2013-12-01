package com.lnu.dao;

import com.lnu.bean.PersonCredentials;
import org.hibernate.Query;
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

    public void createPersonalCredentials(PersonCredentials user) {
        sessionFactory.getCurrentSession().save(user);
    }

   
    
    
    
    
   
    public PersonCredentials findByUserName(String userName) {
        Query query = sessionFactory.getCurrentSession().createQuery("from PersonCredentials where userName=:userName");
        query.setString("userName",userName);
        return (PersonCredentials) query.uniqueResult();
    }
}
