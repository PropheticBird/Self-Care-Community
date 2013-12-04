package com.lnu.service;

import com.lnu.bean.PersonCredentials;

/**
 * User: igor
 * Date: 11/28/13
 */
public interface UserService{

    public void registerUser(PersonCredentials credentials );

    public PersonCredentials getUserProfile(String username);

    public void updateUser(PersonCredentials credentials);

}
