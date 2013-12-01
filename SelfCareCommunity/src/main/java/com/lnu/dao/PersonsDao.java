package com.lnu.dao;

import com.lnu.bean.PersonCredentials;
import com.lnu.bean.Persons;

/**
 * User: igor
 * Date: 11/29/13
 */
public interface PersonsDao {

    void update(Persons person);

    void createPerson(Persons person);

    Persons getPersonForCredentials(PersonCredentials credentials);
}
