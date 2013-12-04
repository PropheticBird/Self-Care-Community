package com.lnu.service;

import com.lnu.bean.PersonCredentials;
import com.lnu.bean.Person;
import com.lnu.dao.PersonalCredentialsDao;
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

    @Transactional
    public void registerUser(PersonCredentials credentials ){
        Person person = new Person();
        credentials.setPerson(person);
        personalCredentialsDao.createPersonalCredentials(credentials);
    }

    @Transactional(readOnly = true)
    public PersonCredentials getUserProfile(String username) {
        return personalCredentialsDao.findByUserName(username);
    }

    @Transactional
    public void updateUser(PersonCredentials newCredentials) {
        PersonCredentials oldCredentials = personalCredentialsDao.findByUserName(newCredentials.getLogin());
        oldCredentials.updateData(newCredentials);
        personalCredentialsDao.update(oldCredentials);
    }

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        PersonCredentials user = personalCredentialsDao.findByUserName(userName);
        return new User(user.getLogin(),user.getPassword(), Arrays.asList(new SimpleGrantedAuthority(ROLE_USER)));
    }
}
