package com.lnu.bean;

import com.lnu.controller.json.converter.JsonDateDeserealizer;
import com.lnu.controller.json.converter.JsonDateSerializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "PERSONS")
public class Person {
	
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
	private Short gender;

    @Column(name = "Zip_Code")
    private Integer zipCode;

	@Column(name = "Disease")
	private String disease;
	
	@Column(name = "Interest")
	private String interest;

    public void updateData(Person newData) {
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
        if(newData.zipCode!=null){
            this.zipCode=newData.zipCode;
        }
        if(newData.disease!=null){
            this.disease=newData.disease;
        }
        if(newData.interest!=null){
            this.interest=newData.interest;
        }
    }

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

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
