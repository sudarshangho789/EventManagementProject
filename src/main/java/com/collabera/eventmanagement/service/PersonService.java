package com.collabera.eventmanagement.service;

import java.util.List;

import com.collabera.eventmanagement.entities.Person;

public interface PersonService {
	public List<Person> listAll() throws Exception;

	public void save(Person person) throws Exception;

	public Person get(long id) throws Exception;

	public void delete(long id) throws Exception;

}
