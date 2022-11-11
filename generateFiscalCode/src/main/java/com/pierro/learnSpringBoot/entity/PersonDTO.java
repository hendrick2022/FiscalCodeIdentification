package com.pierro.learnSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({"message","id", "surname", "firstName", "birthDate", "gender", "town"})
public class PersonDTO {

    private int id;
    private String surname;
    private String firstName;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;
    private String gender;
    private String town;
    private String message;


    public PersonDTO() {
    }

    public PersonDTO(String message) {
        this.message = message;
    }

    public PersonDTO(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDTOInfo{" +
                ", Surname='" + surname + '\'' +
                ", firstName='" + firstName + '\'' +
                ", town='" + town + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
