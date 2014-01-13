package com.lnu.service;

import com.lnu.bean.Person;
import com.lnu.controller.json.UserJsonController;
import com.lnu.dao.MatchingDao;
import com.lnu.dao.PersonalCredentialsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by olga on 13.01.14.
 */
@Service
public class MatchingServiceImpl implements MatchingService{

    @Autowired
    private PersonalCredentialsDao userDao;

    @Autowired
    private MatchingDao matchingDao;

    @Override
    @Transactional(readOnly = true)
    public List<Person> matchRelatedPeople() {
        Person current = userDao.findByUserName(UserJsonController.getCurrentUserName()).getPerson();
        return matchingDao.findRelatedPeople(current);
    }
}
