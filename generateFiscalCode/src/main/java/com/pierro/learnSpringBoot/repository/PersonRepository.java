package com.pierro.learnSpringBoot.repository;


import com.pierro.learnSpringBoot.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {

    Person findByIdentificationCode(String idCode);
    Person deleteByIdentificationCode(String idCode);
    Person getByIdentificationCode(String idCode);

}
