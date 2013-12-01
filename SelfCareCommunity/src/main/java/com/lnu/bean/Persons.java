package com.lnu.bean;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Persons {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "person_id_PK")
	private Long id;
	
	@Column(name = "person_name")
	private String name;
	
	@Column(name = "person_surname")
	private String surname;
	
	@Column(name = "person_birth_date")
	private Date birthDate;
	
	@Column(name = "person_gender")
	private String gender;
	
	@Column(name = "person_health_desease")
	private String healthDesease;
	
	@Column(name = "person_interests")
	private String interests;
	
	@Column(name = "person_profile_picture")
	private String profilePicture;
	
	@Column(name = "person_zip_code")
	private Integer zipCode;

    @OneToOne
    @JoinColumn(name="person_id_FK")
    private PersonCredentials personCredentials;
	
	// Getter and Setter methods
	
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSurname() {
    	return surname;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    public Date getBirthDate() {
    	return birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
    	this.birthDate = birthDate;
    }
    
    public String getGender() {
    	return gender;
    }
    
    public void setGender(String gender) {
    	this.gender = gender;
    }
    
    public String getHealthDesease() {
    	return healthDesease;
    }
    
    public void setHealthDesease(String healthDesease) {
    	this.healthDesease = healthDesease;
    }
    
    public String getInterests() {
    	return interests;
    }
    
    public void setInterests(String interests) {
    	this.interests = interests;
    }
    
    public String getProfilePicture() {
    	return profilePicture;
    }
    
    public void setProfilePicture(String profilePicture) {
    	this.profilePicture = profilePicture;
    }
    
    public Integer getZipCode() {
    	return zipCode;
    }
    
    public void setZipCode(Integer zipCode) {
    	this.zipCode = zipCode;
    }

    public PersonCredentials getPersonCredentials() {
        return personCredentials;
    }

    public void setPersonCredentials(PersonCredentials personCredentials) {
        this.personCredentials = personCredentials;
    }
}
