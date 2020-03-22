package com.example.demo.api;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
	private final PersonService personSevice;

	@Autowired
	public PersonController(PersonService personSevice) {
		super();
		this.personSevice = personSevice;
	}

	@PostMapping
	public Person addPerson(@Valid @NotNull @RequestBody Person person) {
		return personSevice.addPerson(person);
	}

	@GetMapping
	public List<Person> getAllPeople() {
		return personSevice.getAllPeople();
	}

	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id) {
		Optional<Person> optionalPerson = personSevice.getPersonById(id);
		return optionalPerson.orElse(null);
	}

	@DeleteMapping(path = "{id}")
	public int deletePersonById(@PathVariable("id") UUID id) {
		return personSevice.deletePerson(id);
	}

	@PutMapping(path = "{id}")
	public Person updatePerson(@PathVariable UUID id, @Valid @NotNull @RequestBody Person person) {
		Person personToBeUpdated = new Person(id, person.getName());
		return personSevice.updatePerson(id, personToBeUpdated);
	}
}
