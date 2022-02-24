package tema.person;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tema.car.CarRepository;
import tema.curs.Curs;
import tema.curs.CursService;


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
