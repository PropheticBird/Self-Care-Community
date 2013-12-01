package com.lnu.dao;

import com.lnu.bean.PersonCredentials;

/**
 * PersonCredentials: igor
 * Date: 11/28/13
 */
public interface PersonalCredentialsDao {


    public void createPersonalCredentials(PersonCredentials user);

    public PersonCredentials findByUserName(String userName);
}
