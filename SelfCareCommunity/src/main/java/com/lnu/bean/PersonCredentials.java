package com.lnu.bean;

import javax.persistence.*;

/**
 * PersonCredentials: igor
 * Date: 11/28/13
 */
@Entity
@Table(name = "PERSON_CREDENTIALS")
public class PersonCredentials {
	
    @Column(name = "Login")
    private String login;

    @Column(name = "Password")
    private String password;

    @Column(name = "Email")
    private String email;
    
    @Id
    @Column(name = "Person_ID")
    private Long personID;
    
    @OneToOne
    @JoinColumn(name="Person_ID")
    private Persons persons;
    
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
    
    public Long getPersonID() {
        return personID;
    }

    public void setPersonID(Long personID) {
        this.personID = personID;
    }
    
    public Persons getPersons() {
        return persons;
    }

    public void setPersonCredentials(Persons persons) {
        this.persons = persons;
    }
}
