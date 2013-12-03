package com.lnu.bean;

import javax.persistence.*;

/**
 * PersonCredentials: igor
 * Date: 11/28/13
 */
@Entity
@Table(name = "PERSON_CREDENTIALS")
public class PersonCredentials {

    @Id
    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Person_ID")
    private Persons persons;


    public void updateData(PersonCredentials newCredentials) {
        if(newCredentials.email!=null){
            this.email = newCredentials.email;
        }
        this.persons.updateData(newCredentials.getPersons());
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }
}
