package com.lnu.service;

import com.lnu.bean.PersonCredentials;
import com.lnu.bean.Persons;
import com.lnu.dao.PersonalCredentialsDao;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: igor
 * Date: 11/28/13
 */
public interface UserService{

    public void registerUser(PersonCredentials credentials );

    public PersonCredentials getUserProfile(String username);

    public void updateUser(PersonCredentials credentials);

}
