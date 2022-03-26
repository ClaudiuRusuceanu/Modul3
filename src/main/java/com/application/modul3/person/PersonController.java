package com.application.modul3.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.person.dto.PersonCreateDTO;
import com.application.modul3.person.dto.PersonDTO;
import com.application.modul3.person.mapper.PersonMapper;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	@Autowired
	private PersonMapper personMapper;

	@PostMapping()
	public PersonDTO createPerson(@RequestBody PersonCreateDTO personCreateDTO) {
		Person createPerson = personService.createPerson(personMapper.personCreateDTO2person(personCreateDTO));
		return personMapper.person2personDTO(createPerson);
	}

	@PutMapping("/{id}")
	public Person updatePerson(@RequestBody Person person, @PathVariable Integer id) {
		return personService.updatePerson(person, id);
	}

	@GetMapping("/list")
	public List<PersonDTO> getAllPersons() {
		return personMapper.personList2PersonListDTO(personService.getAllPersons());
	}

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable Integer id) {
		return personService.findPersonById(id);
	}

	@DeleteMapping("/{id}")
	public void deletePersonById(@PathVariable Integer id) {
		personService.deletePersonById(id);
	}

	@PutMapping("/{personId}")
	public PersonDTO updatePerson(@RequestBody PersonDTO personDTO, @PathVariable Integer personId) {
		Person person = personService.updatePerson(personMapper.personDTO2person(personDTO), personId);
		return personMapper.person2personDTO(person);
	}

}
