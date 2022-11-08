package com.pierro.learnSpringBoot.repository;


import com.pierro.learnSpringBoot.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {


    Town findByTownName(String townName);

    Optional<Town> findById(long id);

}
