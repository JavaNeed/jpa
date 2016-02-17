package com.journaldev.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Override
	public void addPerson(Person p) {
		repository.save(p);
	}

	@Override
	public void updatePerson(Person p) {
		repository.save(p);
	}

	@Override
	public List<Person> listPersons() {
		List<Person> persons = repository.findAll();
		return persons;
	}

	@Override
	public Person getPersonById(int id) {
		Person person = repository.findById(id);
		return person;
	}

	@Override
	public void removePerson(int id) {
		repository.delete(id);
	}
}
