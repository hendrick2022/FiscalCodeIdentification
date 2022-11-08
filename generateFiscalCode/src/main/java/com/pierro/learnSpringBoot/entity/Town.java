package com.pierro.learnSpringBoot.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

import javax.persistence.*;
@Component
@Entity
@Table(name = "codeTown")
@JsonPropertyOrder({"townCode", "townName"})
//@EnableAutoConfiguration
public class Town {


    @Id
    @Column(name = "town_name")
    private String townName;

    @Column(name = "town_code")
    private String townCode;

    public Town() {
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    @Override
    public String toString() {
        return
                "townCode='" + townCode + '\'' +
                        ", townName='" + townName + '\'' ;

    }

}
