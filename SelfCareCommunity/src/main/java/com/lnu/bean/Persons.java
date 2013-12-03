package com.lnu.bean;

import com.lnu.controller.json.converter.JsonDateDeserealizer;
import com.lnu.controller.json.converter.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Persons {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Surname")
	private String surname;
	
	@Column(name = "Date_of_birth")
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserealizer.class)
	private Date birthDate;
	
	@Column(name = "Gender")
	private Boolean gender;
	
	@Column(name = "Disease")
	private String disease;
	
	@Column(name = "Interest")
	private String interest;
	
	@Column(name = "Picture")
	private String profilePicture;
	
	@Column(name = "Picture_Small")
	private String profilePictureSmall;
	
	@Column(name = "Zip_Code")
	private Integer zipCode;
	
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
    
    public Boolean getGender() {
    	return gender;
    }
    
    public void setGender(Boolean gender) {
    	this.gender = gender;
    }
    
    public String getHealthDesease() {
    	return disease;
    }
    
    public void setHealthDesease(String disease) {
    	this.disease= disease;
    }
    
    public String getInterests() {
    	return interest;
    }
    
    public void setInterests(String interest) {
    	this.interest = interest;
    }
    
    public String getProfilePicture() {
    	return profilePicture;
    }
    
    public void setProfilePicture(String profilePicture) {
    	this.profilePicture = profilePicture;
    }
    
    public String getProfilePictureSmall() {
    	return profilePictureSmall;
    }
    
    public void setProfilePictureSmall(String profilePictureSmall) {
    	this.profilePictureSmall = profilePictureSmall;
    }
    
    public Integer getZipCode() {
    	return zipCode;
    }
    
    public void setZipCode(Integer zipCode) {
    	this.zipCode = zipCode;
    }

	public void updateData(Persons newData) {
        if(newData.name!=null){
            this.name=newData.name;
        }
        if(newData.surname!=null){
            this.surname=newData.surname;
        }
        if(newData.birthDate!=null){
			this.birthDate=newData.birthDate;
		}
		if(newData.gender!=null){
			this.gender=newData.gender;
		}
		if(newData.healthDesease!=null){
			this.healthDesease=newData.healthDesease;
		}
		if(newData.interests!=null){
			this.interests=newData.interests;
		}
		if(newData.profilePicture!=null){
			this.profilePicture=newData.profilePicture;
		}
		if(newData.zipCode!=null){
			this.zipCode=newData.zipCode;
		}	
	}
}
