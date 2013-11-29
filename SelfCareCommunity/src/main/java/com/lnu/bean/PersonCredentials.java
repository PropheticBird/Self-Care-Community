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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "person_credentials_id_PK")
    private Long id;

    @Column(name = "person_credentials_username")
    private String userName;

    @Column(name = "person_credentials_password")
    private String password;

    @Column(name = "person_credentials_email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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


}
