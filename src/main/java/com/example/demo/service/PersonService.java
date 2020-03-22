package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonCRUDAccessService;
import com.example.demo.model.Person;

@Service
public class PersonService {
//	private final PersonDao personDao;
	private final PersonCRUDAccessService personCRUDAccessService;

	@Autowired
	public PersonService(
			/* @Qualifier("postgres") PersonDao personDao, */PersonCRUDAccessService personCRUDAccessService) {
		super();
//		this.personDao = personDao;
		this.personCRUDAccessService = personCRUDAccessService;
	}

	public Person addPerson(Person person) {
		return personCRUDAccessService.save(person);
	}

	public List<Person> getAllPeople() {
		return (List<Person>) personCRUDAccessService.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}

	public Optional<Person> getPersonById(UUID id) {
		return personCRUDAccessService.findById(id);
	}

	public int deletePerson(UUID id) {
		personCRUDAccessService.deleteById(id);
		return 1;
	}

	public Person updatePerson(UUID id, Person newPerson) {
		return personCRUDAccessService.save(newPerson);
	}
}
