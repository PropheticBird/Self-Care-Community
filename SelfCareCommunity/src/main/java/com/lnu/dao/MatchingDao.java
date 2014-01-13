package com.lnu.dao;

import com.lnu.bean.Person;

import java.util.List;

/**
 * Created by olga on 13.01.14.
 */
public interface MatchingDao {


    List<Person> findRelatedPeople(Person toPerson);
}
