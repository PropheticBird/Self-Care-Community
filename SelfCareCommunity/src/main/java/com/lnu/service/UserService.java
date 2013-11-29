package com.lnu.service;

import com.lnu.bean.PersonCredentials;
import com.lnu.dao.PersonalCredentialsDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: igor
 * Date: 11/28/13
 */
@Service
public class UserService {

    @Autowired
    private PersonalCredentialsDao personalCredentialsDao;

    @Transactional
    public void registerUser(PersonCredentials credentials ){
        personalCredentialsDao.savePersonalCredentials(credentials);
    }
}
