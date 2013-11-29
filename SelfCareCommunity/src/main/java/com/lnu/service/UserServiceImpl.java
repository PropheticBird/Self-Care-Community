package com.lnu.service;

import com.lnu.bean.PersonCredentials;
import com.lnu.bean.Persons;
import com.lnu.dao.PersonalCredentialsDao;
import com.lnu.dao.PersonsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * User: igor
 * Date: 11/29/13
 */
@Service("userService")
public class UserServiceImpl implements UserService, UserDetailsService {

    public static final String ROLE_USER = "ROLE_USER";

    @Autowired
    private PersonalCredentialsDao personalCredentialsDao;

    @Autowired
    private PersonsDao personsDao;

    @Transactional
    public void registerUser(PersonCredentials credentials ){
        personalCredentialsDao.savePersonalCredentials(credentials);
    }

    @Override
    @Transactional
    public Persons getUserProfile(String username) {
        PersonCredentials credentials = personalCredentialsDao.findByUserName(username);
        return personsDao.getPersonById(credentials.getId());
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        PersonCredentials user = personalCredentialsDao.findByUserName(userName);
        return new User(user.getUserName(),user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(ROLE_USER)));
    }
}
