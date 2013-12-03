package com.lnu.dao;

import com.lnu.bean.PersonCredentials;

/**
 * PersonCredentials: igor
 * Date: 11/28/13
 */
public interface PersonalCredentialsDao {

    void createPersonalCredentials(PersonCredentials user);

    PersonCredentials findByUserName(String userName);

    void update(PersonCredentials credentials);
}
