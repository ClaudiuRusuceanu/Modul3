package tema.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tema.car.CarRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person createPerson(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person findPersonById(Integer id) {
		Optional<Person> persOpt = personRepository.findById(id);
		if (persOpt.isPresent()) {
			return persOpt.get();
		}
		return null;
	}

	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}

	public Person updatePerson(Person person, Integer id) {
		Person personUpdate = findPersonById(id);
		personUpdate.setNume(person.getNume());
		personUpdate.setPrenume(person.getPrenume());
		personUpdate.setVarsta(person.getVarsta());
		return personUpdate;
	}

}
