package com.lnu.bean.view;

import com.lnu.bean.Person;
import com.lnu.controller.json.converter.JsonDateDeserealizer;
import com.lnu.controller.json.converter.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.Date;

/**
 * User: igor
 * Date: 12/5/13
 */
public class Author {

    private String name;

    private String surname;

    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserealizer.class)
    private Date birthDate;

    private Short gender;

    public static Author createFromPerson(Person person){
        Author result = new Author();
        result.name = person.getName();
        result.surname = person.getSurname();
        result.birthDate=person.getBirthDate();
        result.gender=person.getGender();
        return result;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Short getGender() {
        return gender;
    }
}
