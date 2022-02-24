package tema.curs;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursService {

	@Autowired
	private CursRepository cursRepository;

	public Curs createCurs(Curs curs) {
		return cursRepository.saveAndFlush(curs);
	}

	public List<Curs> getAllCursuri() {
		return cursRepository.findAll();
	}

	public Curs findCursById(Integer id) {
		Optional<Curs> cursOpt = cursRepository.findById(id);
		if (cursOpt.isPresent()) {
			return cursOpt.get();
		}
		return null;
	}

	public void deleteCursById(Integer id) {
		cursRepository.deleteById(id);
	}

	public Curs updateCurs(Curs curs, Integer id) {
		Curs cursUpdate = findCursById(id);
		cursUpdate.setNume(curs.getNume());

		cursRepository.flush();
		return cursUpdate;
	}
	


}
