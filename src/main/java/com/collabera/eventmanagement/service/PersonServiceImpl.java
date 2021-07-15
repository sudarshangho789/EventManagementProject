package com.collabera.eventmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collabera.eventmanagement.entities.Person;
import com.collabera.eventmanagement.repository.PersonRepository;

//this is service class here we are wirting business logic
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	//for display all persons from db
	public List<Person> listAll() throws Exception {
		return personRepository.findAll();
	}

	//to save person in db
	public void save(Person person)throws Exception {
		personRepository.save(person);
	}

	//to get person from db based on id
	public Person get(long id) throws Exception {
		return personRepository.findById(id).get();
	}

	//to delete the person from db based on id
	public void delete(long id)throws Exception {
		personRepository.deleteById(id);
	}
}
