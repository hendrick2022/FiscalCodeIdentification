package com.pierro.learnSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Component
@Entity
public class Person {
    @Id
    private String identificationCode;
    private String Surname;
    private String firstName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;
    private String gender;
    private String town;


    public Person() {
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }


    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    @Override
    public String toString() {
        return "PersonInfo{" +
                "identificationCode='" + identificationCode + '\'' +
                ", Surname='" + Surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", town='" + town + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

