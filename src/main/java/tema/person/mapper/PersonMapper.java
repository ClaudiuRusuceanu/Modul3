package tema.person.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import tema.person.Person;
import tema.person.DTO.PersonCreateDTO;
import tema.person.DTO.PersonDTO;

@Service
public class PersonMapper {

	public PersonDTO person2personDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setNume(person.getNume());
		personDTO.setPrenume(person.getPrenume());
		personDTO.setVarsta(person.getVarsta());
		return personDTO;

	}

	public Person personDTO2person(PersonDTO personDTO) {
		Person person = new Person();
		person.setNume(personDTO.getNume());
		person.setPrenume(person.getPrenume());
		person.setVarsta(person.getVarsta());
		return person;
	}

	public Person personCreateDTO2person(PersonCreateDTO personDTO) {
		Person person = new Person();
		person.setNume(personDTO.getNume());
		person.setPrenume(person.getPrenume());
		person.setVarsta(personDTO.getVarsta());
		return person;
	}

	public List<PersonDTO> personList2PersonListDTO(List<Person> persons) {
		return persons.stream().map(person -> person2personDTO(person)).collect(Collectors.toList());
	}

}
