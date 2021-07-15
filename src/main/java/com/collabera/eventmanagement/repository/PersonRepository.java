package com.collabera.eventmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.eventmanagement.entities.Person;

//its repository which is to perform db related opertaions
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
