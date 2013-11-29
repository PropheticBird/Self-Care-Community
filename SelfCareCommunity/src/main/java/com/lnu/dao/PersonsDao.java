package com.lnu.dao;

import com.lnu.bean.Persons;

/**
 * User: igor
 * Date: 11/29/13
 */
public interface PersonsDao {

    public Persons getPersonById(Long id);
}
