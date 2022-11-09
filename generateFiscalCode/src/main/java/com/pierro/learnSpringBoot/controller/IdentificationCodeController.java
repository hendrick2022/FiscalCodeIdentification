package com.pierro.learnSpringBoot.controller;

import com.pierro.learnSpringBoot.entity.Person;
import com.pierro.learnSpringBoot.repository.PersonRepository;
import com.pierro.learnSpringBoot.repository.TownRepository;
import com.pierro.learnSpringBoot.service.StringManipulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/code")
public class IdentificationCodeController {

    @Autowired
    TownRepository townRepo;
    @Autowired
    PersonRepository personRepo;

    @Autowired
    StringManipulation theString;



    @PostMapping ("/person/getIdCodeAndSave")
    public Person firstPartCode(@RequestBody Person person) {
        if (townRepo.findByTownName(person.getTown()) != null){
            String code = theString.getTheCode(person);
            person.setIdentificationCode(code);
            if(personRepo.findByIdentificationCode(code) == null) {
                System.out.println(person.toString());
                personRepo.save(person);
            }
            return person;
        }else{
            person.setTown("check the spelling of town no such town in our data base") ;
            return person;
        }

    }



    @GetMapping("/person")
    public List<Person> getPersons() {
        List<Person> theList = new ArrayList<>();
        theList = personRepo.findAll();
        return theList;
    }



    @GetMapping("/person/{idCode}")
    public ResponseEntity<Person> get(@PathVariable String idCode) {
        try {
            Person person = personRepo.getByIdentificationCode(idCode);
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }




    @GetMapping("/town/{townName}")
    public String findTown(@PathVariable String townName) {
        try {
            return townRepo.findByTownName(townName).getTownCode();
        }catch (NoSuchElementException e){
            return "no town with such and entry in our data base";
        }
    }



    @PutMapping("/person/{idCode}")
    public String update(@RequestBody Person person, @PathVariable String idCode) {
        try {
            if (personRepo.findByIdentificationCode(idCode) != null) {
                Person wrongPerson = personRepo.findByIdentificationCode(idCode);
                person.setIdentificationCode(theString.getTheCode(person));
                personRepo.save(person);
                personRepo.delete(wrongPerson);
                return " successful update the new identification code is " + person.getIdentificationCode();
            } else {
                return "no body with this id in our data base";
            }
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return "no such element found";
        }
    }




    @DeleteMapping("/person/{identificationCode}")
    public String deleting(@PathVariable String identificationCode) {
        Person myPerson = personRepo.findByIdentificationCode(identificationCode);
        if (myPerson != null){
            personRepo.delete(myPerson);
            return "this person has successfully been deleted";
        }else {
            return "no body has such an id code in this country";
        }
    }



    @DeleteMapping("/person/deleteAll")
    public String deletingAll() {
        personRepo.deleteAll();
        return "empty database for person now";
    }



/**
     @GetMapping("/loadTownsForeign")
     public String loadForeignTowns() {
     theFile.loadTownsInDB("E:\\learnSpringBoot\\learnSpringBoot\\foreignTownCode.csv");

     return "files successfully loaded";
     }


/**
     @GetMapping("/loadTownsItaly")
     public String loadItalyTowns() {
     theFile.loadTownsInDB("E:\\learnSpringBoot\\learnSpringBoot\\CodeTownItaly.csv");

     return "files successfully loaded";
     }

     **/


}
