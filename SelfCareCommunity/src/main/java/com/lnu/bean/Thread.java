package com.lnu.bean;

import javax.persistence.*;

/**
 * User: igor
 * Date: 12/4/13
 */
@Entity
@Table(name = "THREADS")
public class Thread{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Display_Name")
    private String displayName;

    @ManyToOne
    @JoinColumn(name = "Author_ID")
    private PersonCredentials credentials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PersonCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(PersonCredentials credentials) {
        this.credentials = credentials;
    }
}
