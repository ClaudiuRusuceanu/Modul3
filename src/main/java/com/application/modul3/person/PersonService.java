package com.application.modul3.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.car.CarRepository;
import com.application.modul3.curs.Curs;
import com.application.modul3.curs.CursService;
import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CursService cursService;

	public Person createPerson(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person findPersonById(Integer id) {
		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found with id " + id));
	}

	/*
	 * public Person findPersonById(Integer id) { Optional<Person> persOpt =
	 * personRepository.findById(id); if (persOpt.isPresent()) { return
	 * persOpt.get(); } return null; }
	 */

	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}

	public Person updatePerson(Person person, Integer id) {
		Person personUpdate = findPersonById(id);
		personUpdate.setNume(person.getNume());
		personUpdate.setPrenume(person.getPrenume());
		personUpdate.setVarsta(person.getVarsta());

		personRepository.flush();
		return personUpdate;
	}

	public void addCursToPerson(Integer personId, Integer cursId) {
		Person person = findPersonById(personId);
		Curs curs = cursService.findCursById(cursId);
		person.addCurs(curs);
		personRepository.save(person);
	}

}
